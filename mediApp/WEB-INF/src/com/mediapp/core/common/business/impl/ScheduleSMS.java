package com.mediapp.core.common.business.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mediapp.core.common.dao.CommonDAO;

public class ScheduleSMS {
	private CommonDAO commonDAO;

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
    
    @SuppressWarnings("unchecked")
	public boolean schedule(  String phoneNumber, String SMSType,  int personID) {
    	Map<String,String> criteria =  new HashMap < String, String > () ;
    	criteria.put("PhoneNumber", phoneNumber);
    	criteria.put("SMSType", SMSType);
    	Integer iPersonID = new Integer(personID);
    	String sPersonID = iPersonID.toString();
    	criteria.put("PersonID", sPersonID);
    	
    	boolean status = commonDAO.scheduleJob("SMS", criteria, "SMS");
    	return status;
    }

}
