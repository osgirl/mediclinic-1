package com.mediapp.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.AppmentCache;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.business.impl.ScheduleSMS;
import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;
import com.mediapp.domain.common.Admin;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.LogonDomain;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class AdminController extends MediAppBaseController  {
	 
	private final Log logger = LogFactory.getLog(getClass());
	
	CommonService commonService;
	
	AppmentCache appmentCache;
	
	public AppmentCache getAppmentCache() {
		return appmentCache;
	}
	public void setAppmentCache(AppmentCache appmentCache) {
		this.appmentCache = appmentCache;
	}
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
	throws Exception {
		Map < String , Object > logonMap = new HashMap < String , Object > ();
		List <String> appMates = commonService.getAppMates();
		List <CodeDecode> allPackages = new ArrayList<CodeDecode>();
		allPackages=commonService.getAutoComplete("PACKAGES", "%");
		logonMap.put("personIDS", appMates);
		logonMap.put("allPackages", allPackages);
		String userName = request.getParameter("personIDSel");
		logonMap.put("personIDSel", userName);
		if(userName != null){
			Admin admin = new Admin();
			admin.setPersonID(userName);			
			List <String> selectedPackages = commonService.getPackagesForPerson(admin);
			logonMap.put("selectedPackages", selectedPackages);
		}
		List <CodeDecode> storageLocation= appmentCache.getcodeDecodeForCategory("FILESTORAGE");
		if(storageLocation.size()>0){
			logonMap.put("storagePath", storageLocation.get(0).getCodeDecode());			
		}else{
			logonMap.put("storagePath", "");
		}
		return logonMap;
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
		Admin admin = (Admin)command;
		
		if(!"-Select-".equals(admin.getPersonID())){
			boolean result = commonService.updatePackage(admin);
				
		}
				boolean result1 = commonService.updateStorageFilePath(admin);
				appmentCache.reloadCache();
				
		if(!"-Select-".equals(admin.getPersonID())){
			return new ModelAndView("redirect:/adminConsole.htm?personIDSel="+admin.getPersonID().substring(0, admin.getPersonID().indexOf(",")));	
		}else{
			return new ModelAndView("redirect:/adminConsole.htm");
		}
		
		
    }
	/**
	 * @param loginService the loginService to set
	 */
}
