package com.mediapp.core.common.business.impl;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.smslib.InboundMessage;
import org.smslib.smsserver.SMSServer;
import org.springframework.core.task.TaskExecutor;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.core.common.dao.impl.CommonDAOImpl;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.IncomingMessages;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.ScheduleJob;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public class ScheduledJob {

	private final Log logger = LogFactory.getLog(getClass());
	
	private List<ScheduleJob> jobDetails;

	private TaskExecutor taskExecutor;

	private ScheduleEMail sendEmail;

	private CommonDAO commonDAO;
	
	private String uuid;

	private enum MessageTypes {
		/**
		 * Schedule an Appointment.
		 */
		SCD,
		/**
		 * Re-Schedule an Appointment.
		 */
		RESCD,
		/**
		 * Cancel an Appointment.
		 */
		CANCEL,
		/**
		 * View available slots for AppMent.
		 */
		GETTIME,
		/**
		 * Help.
		 */
		HELP
	}

	public List<ScheduleJob> getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(List<ScheduleJob> jobDetails) {
		this.jobDetails = jobDetails;
	}

	public TaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public ScheduleEMail getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(ScheduleEMail sendEmail) {
		this.sendEmail = sendEmail;
	}

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}

	private class ProcessJobInner implements Runnable {

		private ScheduleJob eachJob;

		public ProcessJobInner(ScheduleJob eachJob) {
			this.eachJob = eachJob;
		}

		public void run() {
			if ("Email".equals(eachJob.getActionToPerform())) {
				ScheduleEMail sendEmail = new ScheduleEMail();
				if (eachJob.getActionToPerform() != null) {
					eachJob.setJobStatus("UPRS");
					boolean status = commonDAO
							.updateJobCompletionStatus(eachJob);
				}

				if (CommonCoreConstants.REG_EMAIL_TYPE.equals(eachJob
						.getParameters().get("EmailType"))) {
					Person inputPerson = new Person();
					inputPerson.setUsername(eachJob.getParameters().get(
							"UserName"));
					sendEmail.sendEmailForRegistration(commonDAO
							.getPersonDetails(inputPerson));
				} else if ("newAppointment".equals(eachJob.getParameters().get(
						"EmailType"))) {
					Integer iAppointmentID = new Integer(eachJob
							.getParameters().get("AppointmentID"));
					Appointment appointment = commonDAO
							.getAppointment(iAppointmentID.intValue());
					NotificationDetails notification = commonDAO
							.getNotificationDetails(iAppointmentID);
					sendEmail.sendEmailForNewAppointment(appointment,
							notification);
				} else if ("appointmentConfirmation".equals(eachJob
						.getParameters().get("EmailType"))) {
					Integer iAppointmentID = new Integer(eachJob
							.getParameters().get("AppointmentID"));
					Appointment appointment = commonDAO
							.getAppointment(iAppointmentID.intValue());
					NotificationDetails notification = commonDAO
							.getNotificationDetails(iAppointmentID);
					sendEmail.sendEmailForRescheduledAppointment(appointment,
							notification);
				} else if ("rescheduledAppointment".equals(eachJob
						.getParameters().get("EmailType"))) {
					Integer iAppointmentID = new Integer(eachJob
							.getParameters().get("AppointmentID"));
					Appointment appointment = commonDAO
							.getAppointment(iAppointmentID.intValue());
					NotificationDetails notification = commonDAO
							.getNotificationDetails(iAppointmentID);
					sendEmail.sendEmailForRescheduledAppointment(appointment,
							notification);
				} else if ("cancelAllAppointment".equals(eachJob
						.getParameters().get("EmailType"))) {
					Integer iPersonID = new Integer(eachJob.getParameters()
							.get("PersonID"));
					List<Appointment> appointment = commonDAO
							.getAppointmentAll(iPersonID);
					List<NotificationDetails> notification = commonDAO
							.getNotificationDetailsAll(iPersonID);
					try {
						int count = 0;
						for (Appointment eachAppointment : appointment) {
							sendEmail.sendEmailForCancellationAllAppointment(
									eachAppointment, notification.get(count));
							count = count + 1;
						}
					} catch (Exception se) {
						System.out.println(se.toString());
						System.err.println("stacktrace" + se);

					}

				}

			}
			if (eachJob.getActionToPerform() != null) {
				eachJob.setJobStatus("CMPL");
				boolean status = commonDAO.updateJobCompletionStatus(eachJob);
			}
		}
	}

	public void processJob(List<ScheduleJob> jobDetails) {
		this.jobDetails = jobDetails;
		int prevJobId = 0;
		List<ScheduleJob> jobDetailsToUse = new ArrayList<ScheduleJob>();
		HashMap<String, String> parmObject = new HashMap<String, String>();
		ScheduleJob tempScheduleJob = new ScheduleJob();
		for (ScheduleJob eachjobToSchedule : jobDetails) {
			if (prevJobId != eachjobToSchedule.getJobId()) {
				if (prevJobId > 0) {
					tempScheduleJob.setParameters(parmObject);
					jobDetailsToUse.add(tempScheduleJob);
				}
				prevJobId = eachjobToSchedule.getJobId();
				tempScheduleJob = new ScheduleJob();
				parmObject = new HashMap<String, String>();
				tempScheduleJob.setActionToPerform(eachjobToSchedule
						.getActionToPerform());
				tempScheduleJob.setComments(eachjobToSchedule.getComments());
				tempScheduleJob.setJobId(eachjobToSchedule.getJobId());
				parmObject.put(eachjobToSchedule.getParameterName(),
						eachjobToSchedule.getParameterValue());
			} else {
				parmObject.put(eachjobToSchedule.getParameterName(),
						eachjobToSchedule.getParameterValue());
			}
		}
		tempScheduleJob.setParameters(parmObject);
		jobDetailsToUse.add(tempScheduleJob);
		List<ScheduleJob> jobDetailsToUseForSMS = new ArrayList<ScheduleJob>();
		for (ScheduleJob eachScheduleJob : jobDetailsToUse) {
			if ("SMS".equals(eachScheduleJob.getActionToPerform())) {
				logger.debug("there are SMS jobs to process");
				jobDetailsToUseForSMS.add(eachScheduleJob);
			} else {
				taskExecutor.execute(new ProcessJobInner(eachScheduleJob));
			}
		}
		boolean status =false;
		//taskExecutor.execute(new ProcessSMS());
/*		List<InboundMessage> messageList = new ArrayList<InboundMessage>();
		try {
			logger.debug("reading SMS");
			ReadSMS readSMS = new ReadSMS();
			messageList = readSMS.getAllSMS();
			if(messageList.size()>0){
				status = commonDAO.insertInboundMessages(messageList);				
			}
			readSMS.deleteAllSMS(messageList);
			readSMS.stopService();
			
		} catch (Exception se) {
			System.out.println(se.toString());
			System.err.println("stacktrace" + se);

		}
		logger.debug("SMS job size is : "+jobDetailsToUseForSMS.size());
		if (jobDetailsToUseForSMS.size() > 0) {
			logger.debug("SMS is to be sent....");
			taskExecutor.execute(new ProcessJobInnerSMS(jobDetailsToUseForSMS));
			logger.debug("SMS sending delegated..");
		}
		logger.debug("messages recieved are : "+messageList.size());

		if (messageList.size() > 0) {
			uuid = UUID.randomUUID().toString();
			logger.debug("start processing ....");
			status = commonDAO.updateIncomingSMSJob(null, "SCDL", uuid,
			"UPRS");
			if (status) {
				List<IncomingMessages> incomingMessages = commonDAO
						.getReadMessages(uuid);
				logger.debug("message being processed are in number : "+incomingMessages.size());
				for (IncomingMessages eachMessage : incomingMessages) {
					taskExecutor.execute(new ProcessReadSMS(eachMessage));
				}
			}

		}
		*/
		List<IncomingMessages> incomingMessages = commonDAO.getInSMS();
		if(incomingMessages.size()>0){
			uuid = UUID.randomUUID().toString();
			boolean statusOfUpdates = commonDAO.updateInSMS(incomingMessages, uuid,"U");
			logger.debug("message being processed are in number : "+incomingMessages.size());
			for (IncomingMessages eachMessage : incomingMessages) {
				taskExecutor.execute(new ProcessReadSMS(eachMessage));
			}
		}
	}

	private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			df.setLenient(false);
			// System.out.println("created");
			return df;
		}
	};

	private static final ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			df.setLenient(false);
			// System.out.println("created");
			return df;
		}
	};

	private class ProcessJobInnerSMS implements Runnable {

		private List<ScheduleJob> allSMSJobs;

		public ProcessJobInnerSMS(List<ScheduleJob> allSMSJobs) {
			this.allSMSJobs = allSMSJobs;
		}

		public void run() {
			for (ScheduleJob eachjobToSchedule : allSMSJobs) {
				if ("SMS".equals(eachjobToSchedule.getActionToPerform())) {
					if (eachjobToSchedule.getActionToPerform() != null) {
						eachjobToSchedule.setJobStatus("UPRS");
						boolean status = commonDAO
								.updateJobCompletionStatus(eachjobToSchedule);
					}

					SendSMS sendSMS = new SendSMS();
					if (CommonCoreConstants.REG_EMAIL_TYPE
							.equals(eachjobToSchedule.getParameters().get(
									"SMSType"))) {
						try {
							sendSMS.sendSMSForRegistration(eachjobToSchedule
									.getParameters().get("PhoneNumber"));
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);

						}
					} else if ("newAppointment".equals(eachjobToSchedule
							.getParameters().get("SMSType"))) {
						Integer iAppointmentID = new Integer(eachjobToSchedule
								.getParameters().get("AppointmentID"));
						Appointment appointment = commonDAO
								.getAppointment(iAppointmentID.intValue());
						NotificationDetails notification = commonDAO
								.getNotificationDetails(iAppointmentID);
						try {
							sendSMS.sendSMSForNewAppointment(appointment,
									notification);
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);

						}

					} else if ("appointmentConfirmation"
							.equals(eachjobToSchedule.getParameters().get(
									"SMSType"))) {
						Integer iAppointmentID = new Integer(eachjobToSchedule
								.getParameters().get("AppointmentID"));
						Appointment appointment = commonDAO
								.getAppointment(iAppointmentID.intValue());
						NotificationDetails notification = commonDAO
								.getNotificationDetails(iAppointmentID);
						try {
							sendSMS.sendSMSForAppointmentConfirmation(
									appointment, notification);
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);

						}

					} else if ("rescheduledAppointment"
							.equals(eachjobToSchedule.getParameters().get(
									"SMSType"))) {
						Integer iAppointmentID = new Integer(eachjobToSchedule
								.getParameters().get("AppointmentID"));
						Appointment appointment = commonDAO
								.getAppointment(iAppointmentID.intValue());
						NotificationDetails notification = commonDAO
								.getNotificationDetails(iAppointmentID);
						try {
							sendSMS.sendSMSForRescheduledAppointment(
									appointment, notification);
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);

						}

					} else if ("cancelAllAppointment".equals(eachjobToSchedule
							.getParameters().get("SMSType"))) {
						Integer iPersonID = new Integer(eachjobToSchedule
								.getParameters().get("PersonID"));
						// String appointmentList =
						// commonDAO.getAppointmentList(iPersonID);
						List<Appointment> appointment = commonDAO
								.getAppointmentAll(iPersonID);
						List<NotificationDetails> notification = commonDAO
								.getNotificationDetailsAll(iPersonID);
						try {
							int count = 0;
							for (Appointment eachAppointment : appointment) {
								sendSMS.sendSMSForAllCancelledAppointment(
										eachAppointment, notification
												.get(count));
								count = count + 1;
								wait(200);
							}
							// sendSMS.sendSMSForRescheduledAppointment(appointment,
							// notification) ;
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);

						}

					}else if ("sendErrorSMS".equals(eachjobToSchedule
							.getParameters().get("SMSType"))) {
						try {
							sendSMS.sendErrorSMS(eachjobToSchedule.getParameters().get("PhoneNumber"), 
									eachjobToSchedule.getParameters().get("Message"));
						} catch (Exception se) {
							System.out.println(se.toString());
							System.err.println("stacktrace" + se);
						}
						
					}
				}
				if (eachjobToSchedule.getActionToPerform() != null) {
					eachjobToSchedule.setJobStatus("CMPL");
					boolean status = commonDAO
							.updateJobCompletionStatus(eachjobToSchedule);
				}

			}
		}
	}

	private class ProcessReadSMS implements Runnable {
		private IncomingMessages readMessage;

		public ProcessReadSMS(IncomingMessages readMessage) {
			this.readMessage = readMessage;
		}

		public void run() {
			// boolean exists = false;
			MessageTypes action = null;
			String[] splitString = null;
			splitString = readMessage.getMessageText().split(" ");			
			logger.debug("splitted string length is " + splitString.length);
			Person validatedPerson = new Person();
			for (MessageTypes eachElement : EnumSet.allOf(MessageTypes.class)) {
				if (eachElement.name().equals(splitString[0])) {
					Person person = new Person();
					if (splitString.length >= 2) {
						person.setUsername(splitString[1]);
						validatedPerson = commonDAO.getPersonDetails(person);
						if (null != validatedPerson.getLastName()
								&& !"".equals(validatedPerson.getLastName())) {
							if (readMessage.getSenderNumber().indexOf(
									validatedPerson.getCellPhoneNumber()) != -1) {
								action = eachElement;
							}

						}
					}
					break;
				}
			}
			logger.debug("action is : " +action);
			if(null != action){
				switch (action) {
				case CANCEL:
					//CANCEL <yourusername> <mm/dd/yyyy> <hh:mm:ss>
					validateAndCancelAppointment(readMessage, validatedPerson);
				case GETTIME:
					//GETTIME <yourusername> <mm/dd/yyyy> <appmateusername>				
					getAvailableTimeSlots(readMessage, validatedPerson);
				case RESCD:
					//RESCD <yourusername> <old mm/dd/yyyy> <old hh:mm:ss> <new mm/dd/yyyy> <new hh:mm:ss> <duration hh:mm:ss>				
					rescheduleAppointment(readMessage, validatedPerson);
				case SCD:
					//SCD <yourusername> <mm/dd/yyyy> <hh:mm:ss> <duration hh:mm:ss> <appmateusername>					
					scheduleAppointment(readMessage, validatedPerson);
				case HELP:
					//HELP				
					help(readMessage);
				default:
					logger.debug("action is not valid! " +action);
					error(readMessage, "Not valid Option");
				}				
			}else{
				error(readMessage, "Not valid Option");
			}
			//boolean status = commonDAO.updateIncomingSMSJob(uuid, "UPRS", uuid,"CMPL");
			List<IncomingMessages> updateMessage = new   ArrayList<IncomingMessages>();
			updateMessage.add(readMessage);			
			boolean statusOfUpdates = commonDAO.updateInSMS(updateMessage, uuid,"C");

		}
	}

	public void validateAndCancelAppointment(IncomingMessages readMessage,
			Person validatedPerson) {
		String[] splitString = readMessage.getMessageText().split(" ");
		if (splitString.length >= 3) {
			boolean isValid = validateDate(splitString[2]);
			if (isValid) {
				if (splitString.length >= 4) {
					isValid = validateTime(splitString[3]);
					if (isValid) {
						Appointment appointment = new Appointment();
						appointment
								.setDateOfAppointment(convertStringToDate(splitString[2]));
						appointment
								.setTimeOfAppointment(convertStringToTime(splitString[3]));
						appointment.setConfirmedIndicator("C");
						appointment.setPatientPersonID(validatedPerson
								.getIdPerson());
						if (!commonDAO
								.updateAppointmentConfirmationThruSMS(appointment)) {
							error(readMessage,"Could not cancel appointment.");
						}else{
							sendSuccessMessage(readMessage, "Appointment successfully cancelled!");
						}
					} else {
						error(readMessage, "Time was not in correct format for cancelling appointment.");
					}
				} else {
					error(readMessage,"Format of message sent for cancelling not correct.");
				}
			} else {
				error(readMessage, "Date was not in correct format for cancelling appointment.");
			}
		} else {
			error(readMessage,"Format of message sent for cancelling not correct.");
		}
	}

	public void getAvailableTimeSlots(IncomingMessages readMessage,
			Person validatedPerson) {

	}

	public void rescheduleAppointment(IncomingMessages readMessage,
			Person validatedPerson) {
		String[] splitString = readMessage.getMessageText().split(" ");
		logger.debug("Rescheduling SMS length :"+splitString.length);
		if (splitString.length >= 3) {
			logger.debug("Rescheduling Date is :"+splitString[2]);
			boolean isValid = validateDate(splitString[2]);
			if (isValid) {
				if (splitString.length >= 4) {
					logger.debug("Rescheduling Time is :"+splitString[3]);
					isValid = validateTime(splitString[3]);					
					if (isValid) {
						if (splitString.length >= 5) {
							logger.debug("Rescheduling new Date is :"+splitString[4]);
							isValid = validateDate(splitString[4]);
							if (isValid) {
								logger.debug("Rescheduling new Time is :"+splitString[5]);
								Appointment appointment = new Appointment();
								appointment
										.setDateOfAppointment(convertStringToDate(splitString[2]));
								appointment
										.setTimeOfAppointment(convertStringToTime(splitString[3]));
								if (validateTime(splitString[6])) {
									logger.debug("Rescheduling new duration is :"+splitString[6]);
									appointment
									.setAppointmentDuration(convertStringToTime(splitString[6]));
								} else {
									error(readMessage,"Time was not in correct format for rescheduling appointment.");
								}
								appointment.setPatientPersonID(validatedPerson
										.getIdPerson());
								Appointment outputAppointment =commonDAO
										.checkIfAppointmentExists(appointment);								
								if (null != outputAppointment && outputAppointment.getAppointmentID() > 0) {
									appointment.setAppointmentID(outputAppointment.getAppointmentID());
									SearchCriteria searchCriteria = new SearchCriteria();
									searchCriteria.setUsername(outputAppointment.getDoctorUserName());
									searchCriteria.setDateOfAppointment(convertStringToDate(splitString[4]));
									List<SearchResult> searchResults = commonDAO
											.getDoctors(searchCriteria);
									if (searchResults.size() == 1) {
										appointment
												.setDoctorPersonID(searchResults
														.get(0).getIdPerson());
										appointment
										.setDateOfAppointment(convertStringToDate(splitString[4]));
										appointment
										.setTimeOfAppointment(convertStringToTime(splitString[5]));

										if (commonDAO
												.checkIfAppointmentAvailable(appointment) == 0) {
											commonDAO
													.rescheduleAppointment(appointment);
											sendSuccessMessage(readMessage, "Appointment rescheduled successfully!");
										} else {
											error(readMessage, "Appointment cannot be scheduled as this time slot was not available.");
										}
									} else {
										error(readMessage,"The appointment you are trying to reschedule does not exist.");
									}

								} else {
									error(readMessage,"Appointment cannot be rescheduled as it does not exist.");
								}
							} else {
								error(readMessage,"Date was not in correct format for rescheduling appointment.");
							}
						}
					} else {
						error(readMessage,"Time was not in correct format for rescheduling appointment.");
					}
				} else {
					error(readMessage,"Message format not correct for rescheduling appointment.");
				}
			} else {
				error(readMessage,"Date was not in correct format for rescheduling appointment.");
			}
		} else {
			error(readMessage,"Message format not correct for rescheduling appointment.");
		}
	}

	public void scheduleAppointment(IncomingMessages readMessage,
			Person validatedPerson) {
		String[] splitString = readMessage.getMessageText().split(" ");
		if (splitString.length >= 3) {
			boolean isValid = validateDate(splitString[2]);
			if (isValid) {
				if (splitString.length >= 4) {
					isValid = validateTime(splitString[3]);
					if (isValid) {
						SearchCriteria searchCriteria = new SearchCriteria();
						if (splitString.length >= 6 && !splitString[1].equals(splitString[5])) {
							searchCriteria.setUsername(splitString[5]);
							searchCriteria.setDateOfAppointment(convertStringToDate(splitString[2]));
							List<SearchResult> searchResults = commonDAO
									.getDoctors(searchCriteria);
							if (searchResults.size() == 1) {
								Appointment appointment = new Appointment();
								appointment
										.setAppointmentDuration(convertStringToTime(splitString[4]));
								appointment
										.setDateOfAppointment(convertStringToDate(splitString[2]));
								appointment
										.setTimeOfAppointment(convertStringToTime(splitString[3]));
								appointment.setDoctorPersonID(searchResults
										.get(0).getIdPerson());
								appointment.setPatientPersonID(validatedPerson
										.getIdPerson());
								if (commonDAO
										.checkIfAppointmentAvailable(appointment) == 0) {
									appointment
											.setHeadline("Appointment Thru SMS");
									appointment.setConfirmedIndicator("N");
									commonDAO.insertNewAppointment(appointment);
									sendSuccessMessage(readMessage, "Appointment scheduled successfully!");
								} else {
									error(readMessage,"Appointment not available at this time.");
								}
							} else {
								error(readMessage,"The Appmate ID send for scheduling not valid.");
							}
						} else {
							error(readMessage,"Message not in correct format for scheduling appointment.");
						}

					} else {
						error(readMessage,"Time was not in correct format for scheduling appointment.");
					}
				} else {
					error(readMessage,"Message format for rescheduling appointment.");
				}
			} else {
				error(readMessage,"Date was not in correct format for rescheduling appointment.");
			}
		} else {
			error(readMessage,"Message format for rescheduling appointment.");
		}
	}

	public void help(IncomingMessages readMessage) {

	}

	public void error(IncomingMessages readMessage, String errorMessage) {
		boolean status = commonDAO.sendOutSMS(readMessage.getSenderNumber(), errorMessage);
	}

	public void sendSuccessMessage(IncomingMessages readMessage, String successMessage) {
    	boolean status = commonDAO.sendOutSMS(readMessage.getSenderNumber(), successMessage);
	}

	
	public static boolean validateDate(String date) {
		try {
			dateFormat.get().parse(date);
		} catch (ParseException ex) {
			System.out.println("error in validating date ");
			return false;
		}
		return true;
	}

	public static boolean validateTime(String time) {
		try {
			timeFormat.get().parse(time);
		} catch (ParseException ex) {
			System.out.println("error in validating time ");
			return false;
		}
		return true;
	}

	public static Date convertStringToDate(String date) {
		Date returnDate = null;
		try {
			returnDate = dateFormat.get().parse(date);
		} catch (ParseException ex) {
			System.out.println("error in validating date ");
		}
		return returnDate;
	}

	public static Time convertStringToTime(String time) {
		Time returnTime = new Time(10);
		try {
			returnTime.setTime(timeFormat.get().parse(time).getTime());
		} catch (ParseException ex) {
			System.out.println("error in validating time ");
		}
		return returnTime;
	}


	
}
