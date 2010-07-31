package com.mediapp.core.common.business.impl;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
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
import com.mediapp.domain.common.CodeDecode;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
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
	    public  void send(final String emailTo,final String emailType) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {	        	
	            public void prepare(MimeMessage mimeMessage) throws MessagingException {	            	
	            	Map model = new HashMap();
	            	model.put("email.sender", "mediApp");
	            	model.put("email.user", emailTo);
	            	model.put("password", "mediApp");
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo(emailTo);
	               if(CommonCoreConstants.REG_EMAIL_TYPE.equals(emailType)){
		               message.setSubject("Welcome to MediApp");
		               String body = null;
		               if(velocityEngine==null){		            	   
		            	   VelocityEngine velocityEngine = new VelocityEngine();
		            	   velocityEngine.setProperty("resource.loader","class");
		            	   velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		            	   //velocityEngine.setProperty("file.resource.loader.path","C:\\Documents and Settings\\Administrator\\Desktop\\padmaraj\\demo\\mediclinic\\workspace\\with search\\work1\\mediApp\\WEB-INF\\classes\\resources\\common\\velocity\\");
		            	   
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/template.vm", model);
		               }else{
		            	   body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/template.vm", model);
		               }   
		               message.setText(body, true);		               
	               }
            		
	            }
	        };
	         
	         try{
	        	if (mailSender == null){
	        		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        		mailSender.setHost("smtp.gmail.com");
	        		mailSender.setPort(465);
	        		mailSender.setProtocol("smtps");
	        		mailSender.setUsername("mediappindia@gmail.com");
	        		mailSender.setPassword("mh12ac830");
	        		Properties properties = new Properties();
	        		properties.setProperty("mail.smtps.auth", "true");
	        		properties.setProperty("mail.smtps.starttls.enable", "true");
	        		properties.setProperty("mail.smtps.debug", "true");
	        		mailSender.setJavaMailProperties(properties);
	        		mailSender.send(preparator);
	        		System.out.println("Emailed "+emailTo  + "for " + emailType);
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
		public boolean schedule( String emailTo, String emailType,  int personID) {
	    	Map<String,String> criteria =  new HashMap < String, String > () ;
	    	criteria.put("EmailTo", emailTo);
	    	criteria.put("EmailType", emailType);
	    	Integer iPersonID = new Integer(personID);
	    	String sPersonID = iPersonID.toString();
	    	criteria.put("PersonID", sPersonID);
	    	boolean status = commonDAO.scheduleJob("Email", criteria, "Emailing");
	    	return status;
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

}