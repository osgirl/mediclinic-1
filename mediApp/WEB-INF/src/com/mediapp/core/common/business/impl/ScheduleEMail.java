package com.mediapp.core.common.business.impl;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.mediapp.core.common.constants.CommonCoreConstants;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;


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
	    public void send(final String emailTo,final String emailType) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	            	Map model = new HashMap();
	            	model.put("email.sender", "padmaraj");
	            	model.put("email.user", emailTo);
	               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	               message.setTo("padmaraj.m@gmail.com");
	               //message.setFrom("a459740@fidelity.com");
	               if(emailType==CommonCoreConstants.REG_EMAIL_TYPE){
		               message.setSubject("Hi");
		               String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/resources/common/velocity/template.vm", model);
		               message.setText(body, true);	            	   
	               }
	            }
	         };
	         
	         mailSender.send(preparator);
	       
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