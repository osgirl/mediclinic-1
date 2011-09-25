package com.mediapp.web.controller.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Errors;

import com.mediapp.core.common.business.impl.AppmentCache;
import com.mediapp.domain.common.ReportPackage;

public class HelpController extends MediAppBaseController {
	
	AppmentCache appmentCache;
	

	public AppmentCache getAppmentCache() {
		return appmentCache;
	}


	public void setAppmentCache(AppmentCache appmentCache) {
		this.appmentCache = appmentCache;
	}

	protected Map referenceData(HttpServletRequest request, Object command,
			Errors errors) throws Exception {
		Map < String , Object > helpMap = new HashMap < String , Object > ();
		String pageName = request.getParameter("PageName");
		String componentName = request.getParameter("ComponentName");
		String help= appmentCache.getHelpForComponent(pageName, componentName);
		helpMap.put("Title", pageName+":"+componentName);
		helpMap.put("Body", help);
		
		return helpMap;
		
	}

}
