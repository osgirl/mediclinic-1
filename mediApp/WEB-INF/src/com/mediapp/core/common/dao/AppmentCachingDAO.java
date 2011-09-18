package com.mediapp.core.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.ReportPackage;


public interface AppmentCachingDAO {
	
	public List < CodeDecode > getCodeDecode() throws DataAccessException;
	
	public List < ReportPackage > getReportPackage() throws DataAccessException;
}
