package com.mediapp.core.common.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.dao.AppmentCachingDAO;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.ReportPackage;

public class AppmentCachingDAOImpl  extends MediAppBaseDAOImpl  implements AppmentCachingDAO {
	public List < CodeDecode > getCodeDecode() throws DataAccessException{		
		return (ArrayList<CodeDecode>) getListNoOptions("common.getCodeDecode");
	}

	public List < ReportPackage > getReportPackage() throws DataAccessException{
		Map<String,String> reports =  new HashMap < String, String > () ;
		 reports = (Map<String,String>)getMap("common.getReports", null,"report_name", "report_search_criteria");
//		List<String[]> reports = (List<String[]>) getListNoOptions("common.getReports");
		List < ReportPackage > reportpackage = new ArrayList<ReportPackage>();
		Map<String,String> reportToPackage =  new HashMap < String, String > () ;
		reportToPackage = (Map<String,String>)getMap("common.getReportPackage", null,"report_name", "package");		
	    Iterator it = reports.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
			ReportPackage rept = new ReportPackage();
			rept.setReportName(pairs.getKey().toString());
			rept.setSearchCriteria(pairs.getValue().toString());
	        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        Iterator it1 = reportToPackage.entrySet().iterator();
	        List packg = new ArrayList();
	        while (it1.hasNext()) {
	        	Map.Entry pairs1 = (Map.Entry)it1.next();
	        	if(pairs.getKey().equals(pairs1.getKey())){
	        		packg.add(pairs1.getValue().toString());
	        	}
	        }
	        rept.setPackageName(packg);
	        reportpackage.add(rept);
	        rept=null;
	        packg=null;

	        
	    }
		return reportpackage;
	}
	
}
