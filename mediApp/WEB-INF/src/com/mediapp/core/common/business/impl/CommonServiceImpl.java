package com.mediapp.core.common.business.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.constants.CommonCoreConstants;
import com.mediapp.core.common.dao.CommonDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public class CommonServiceImpl implements CommonService{

	protected final Log logger = LogFactory.getLog(getClass());

	private CommonDAO commonDAO;

	public List <CodeDecode> getAutoComplete(String codeCategory,String code){
		return commonDAO.getAutoComplete( codeCategory,code);
		
	}

	public CommonDAO getCommonDAO() {
		return commonDAO;
	}

	public void setCommonDAO(CommonDAO commonDAO) {
		this.commonDAO = commonDAO;
	}
	
	public List <SearchResult> getDoctors(SearchCriteria searchCriteria){

		if (searchCriteria.getDateOfAppointment() == null){
			GregorianCalendar calendar = new GregorianCalendar();
			Date now = calendar.getTime();
			searchCriteria.setDateOfAppointment(now);			
		}
		
		return commonDAO.getDoctors(searchCriteria);
	}
}
