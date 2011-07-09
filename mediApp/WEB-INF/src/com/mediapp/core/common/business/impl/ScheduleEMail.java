package com.mediapp.core.common.business.impl;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.Appointment;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.HolidayCalendarList;
import com.mediapp.domain.common.NotificationDetails;
import com.mediapp.domain.common.Person;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class ScheduleEMail {
//	   private static final Logger logger = LogFactory.getLogger(SendeMail.class);

	    private  VelocityEngine velocityEngine;
	    private  JavaMailSender mailSender;

	    

		/**
	     * Sends e-mail using Velocity template for the body and 
	     * the properties passed in as Velocity variables.
	     * 
	     * @param   msg                 The e-mail message to be sent, except for the body.
	     * @param   hTemplateVariables  Variables to use when processing the template. 
	     */
	    public  void sendEmailForRegistration(final Person person ) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("email.sender", "mediApp");
	            	model.put("email.user", person.getEmailID());
	            	model.put("username", person.getUsername());
	            	model.put("password", person.getPassword());
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(person.getEmailID());
	                   message.setSubject("Thank you for joining us!");
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/registration.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/registration.vm", model);
		               }   
		               message.setText(body, true);		               
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("appment@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);	        		
	        	}else{
	        		mailSender.send(preparator);
	        	}
	            
	         }catch (Exception se) {
	             //log it and go on
	 			//System.out.println(se.toString());
				System.err.println("stacktrace"+se);
            
	         }

	       
	    }
	    
	    public  void sendEmailForNewAppointment(final Appointment  appointment,final NotificationDetails notificationDetails) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("doctorName", notificationDetails.getDoctorName());
	            	model.put("patientName", notificationDetails.getPatientName());
	            	model.put("headline", appointment.getHeadline());
	            	model.put("date", convertStringToDate(appointment.getDateOfAppointment()));
	            	model.put("time", appointment.getTimeOfAppointment());
	            	model.put("duration", appointment.getAppointmentDuration());
	            	model.put("comments", appointment.getComments());	            	
	            	
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(notificationDetails.getDoctorEmailAddress());
	               message.setCc(notificationDetails.getPatientEmailAddress());
	               message.setSubject("New Appointment Notification");
	               FileSystemResource res = new FileSystemResource(new File("C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\images\\logoForEmail.JPG"));
	               message.addInline("logo", res);
	                   
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/newAppointment.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/newAppointment.vm", model);
		               }   
		               message.setText(body, true);		               
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("appment@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);	        		
	        	}else{
	        		mailSender.send(preparator);
	        	}
	            
	         }catch (Exception se) {
	             //log it and go on
	 			//System.out.println(se.toString());
				System.err.println("stacktrace"+se);
            
	         }

	         
	       
	    }
	    
	    public  void sendEmailForRescheduledAppointment(final Appointment  appointment,final NotificationDetails notificationDetails) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("doctorName", notificationDetails.getDoctorName());
	            	model.put("patientName", notificationDetails.getPatientName());
	            	model.put("headline", appointment.getHeadline());
	            	model.put("date", convertStringToDate(appointment.getDateOfAppointment()));
	            	model.put("time", appointment.getTimeOfAppointment());
	            	model.put("duration", appointment.getAppointmentDuration());
	            	model.put("comments", appointment.getComments());	            	
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(notificationDetails.getDoctorEmailAddress());
	               message.setCc(notificationDetails.getPatientEmailAddress());
	                   message.setSubject("Appointment Reschedule Notification");
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/rescheduledAppointment.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/rescheduledAppointment.vm", model);
		               }   
		               message.setText(body, true);		               
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("appment@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);	        		
	        	}else{
	        		mailSender.send(preparator);
	        	}
	            
	         }catch (Exception se) {
	             //log it and go on
	 			//System.out.println(se.toString());
				System.err.println("stacktrace"+se);
            
	         }

	         
	       
	    }

	    public  void sendEmailForAppointmentConfirmation(final Appointment  appointment,final NotificationDetails notificationDetails) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("doctorName", notificationDetails.getDoctorName());
	            	model.put("patientName", notificationDetails.getPatientName());
	            	model.put("headline", appointment.getHeadline());
	            	model.put("date", convertStringToDate(appointment.getDateOfAppointment()));
	            	model.put("time", appointment.getTimeOfAppointment());
	            	model.put("duration", appointment.getAppointmentDuration());
	            	model.put("comments", appointment.getComments());	            	
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(notificationDetails.getPatientEmailAddress());
	               message.setCc(notificationDetails.getDoctorEmailAddress());
                   message.setSubject("Appointment Confirmation Notification");
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/appointmentConfirmation.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/appointmentConfirmation.vm", model);
		               }   
		               message.setText(body, true);		               
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("appment@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);	        		
	        	}else{
	        		mailSender.send(preparator);
	        	}
	            
	         }catch (Exception se) {
	             //log it and go on
	 			//System.out.println(se.toString());
				System.err.println("stacktrace"+se);
            
	         }

	         
	       
	    }


		private CommonDAO commonDAO;

		public CommonDAO getCommonDAO() {
			return commonDAO;
		}

		public void setCommonDAO(CommonDAO commonDAO) {
			this.commonDAO = commonDAO;
		}
	    
	    @SuppressWarnings("unchecked")
		public boolean scheduleRegistration( String emailTo, String emailType,  String userName) {
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailTo", emailTo);
	    	criteria.put("EmailType", emailType);
	    	criteria.put("UserName", userName);
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
	    }
	    
	    @SuppressWarnings("unchecked")
		public boolean scheduleNewAppointment( Appointment newAppointment) {
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailType", "newAppointment");
	    	Integer iAppointmentID = new Integer(newAppointment.getAppointmentID());
	    	String sAppointmentID = iAppointmentID.toString();
	    	criteria.put("AppointmentID",sAppointmentID );
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
	    }

	    @SuppressWarnings("unchecked")
		public boolean scheduleRescheduleAppointment( Appointment newAppointment) {
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailType", "rescheduledAppointment");
	    	Integer iAppointmentID = new Integer(newAppointment.getAppointmentID());
	    	String sAppointmentID = iAppointmentID.toString();
	    	criteria.put("AppointmentID",sAppointmentID );
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
	    }

		public boolean scheduleAppointmentConfirmation( int appointmentID) {
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailType", "appointmentConfirmation");
	    	Integer iAppointmentID = new Integer(appointmentID);
	    	String sAppointmentID = iAppointmentID.toString();
	    	criteria.put("AppointmentID",sAppointmentID );
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
	    }
		
	    public boolean scheduleAppointmentCancellation(int idPerson){
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailType", "cancelAllAppointment");
	    	Integer iPersonID = new Integer(idPerson);
	    	String sPersonID = iPersonID.toString();
	    	criteria.put("PersonID",sPersonID );
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
	    }

	    
	    public  void sendEmailForCancellationAllAppointment(final Appointment  appointment,final NotificationDetails notificationDetails) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("doctorName", notificationDetails.getDoctorName());
	            	model.put("patientName", notificationDetails.getPatientName());
	            	model.put("headline", appointment.getHeadline());
	            	model.put("date", convertStringToDate(appointment.getDateOfAppointment()));
	            	model.put("time", appointment.getTimeOfAppointment());
	            	model.put("duration", appointment.getAppointmentDuration());
	            	model.put("comments", appointment.getComments());	            	
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setCc(notificationDetails.getDoctorEmailAddress());
	               message.setTo(notificationDetails.getPatientEmailAddress());
	                   message.setSubject("New Appointment Notification");
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/cancelAllAppointment.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/cancelAllAppointment.vm", model);
		               }   
		               message.setText(body, true);		               
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("appment@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);	        		
	        	}else{
	        		mailSender.send(preparator);
	        	}
	            
	         }catch (Exception se) {
	             //log it and go on
	 			//System.out.println(se.toString());
				System.err.println("stacktrace"+se);
            
	         }

	         
	       
	    }


	    public JavaMailSender getMailSender() {
			return mailSender;
		}


		public void setMailSender(JavaMailSender mailSender) {
			this.mailSender = mailSender;
		}


		public VelocityEngine getVelocityEngine() {
			return velocityEngine;
		}


		public void setVelocityEngine(VelocityEngine velocityEngine) {
			this.velocityEngine = velocityEngine;
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
		
		public static String convertStringToDate(Date date) {
			return dateFormat.get().format(date);
		}

		public static String convertStringToTime(Time time) {
			return dateFormat.get().format(time);
		}

}