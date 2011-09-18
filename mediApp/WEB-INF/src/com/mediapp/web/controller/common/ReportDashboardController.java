/**
 *
 */
package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.impl.AppmentCache;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.ReportPackage;
import com.mediapp.web.constants.common.CommonWebConstants;

public class ReportDashboardController extends MediAppBaseController {
	AppmentCache appmentCache;
	

	public AppmentCache getAppmentCache() {
		return appmentCache;
	}


	public void setAppmentCache(AppmentCache appmentCache) {
		this.appmentCache = appmentCache;
	}


	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Map < String , Object > inboxMap = new HashMap < String , Object > ();
		List <ReportPackage> reportPackage= appmentCache.getReportPackage();
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		List <String> packg = sessionPerson.getPackages();
		List <String> reports = new ArrayList<String>();
		Map < String , String > reportMap = new HashMap < String , String > ();
		for(ReportPackage rpt: reportPackage){
			for(String rptpkg : rpt.getPackageName()){
				for(String pkg : sessionPerson.getPackages()){
					if(rptpkg.equals(pkg)){
						reports.add(rpt.getReportName());
						reportMap.put(rpt.getReportName(), rpt.getSearchCriteria());
					}	
				}
			}
		}
		inboxMap.put("Reports", reports);
		inboxMap.put("ReportMap", reportMap);
		return inboxMap;
	}
	
//	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		
//	}
}
