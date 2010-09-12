package com.mediapp.domain.common;

import java.util.Date;

public class IncomingMessages extends MediAppBaseDomain{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1332122321L;
	
	private String senderNumber;
	
	private String messageText;
	
	private int messageId;
	
	private Date sentOn;
	
	private Date processedOn;

	public String getSenderNumber() {
		return senderNumber;
	}

	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Date getSentOn() {
		return sentOn;
	}

	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}

	public Date getProcessedOn() {
		return processedOn;
	}

	public void setProcessedOn(Date processedOn) {
		this.processedOn = processedOn;
	}

}
