package com.mediapp.web.controller.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.LoginService;
import com.mediapp.core.common.business.impl.CommonServiceImpl;
import com.mediapp.core.common.business.impl.ScheduleEMail;
import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.Person;
import com.mediapp.domain.common.LogonDomain;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;


public class AppointmentPopUpController extends MediAppBaseController  {
	 
	private final Log logger = LogFactory.getLog(getClass());

	CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}


	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
	throws Exception {
	/*	Person logon = (Person) command;
		List <CodeDecode> logonPersonType = loginService.getPersonType();
		if (request.getSession().getAttribute("logonCriteria") == null) {
			request.getSession().setAttribute("logonCriteria", logonPersonType);
		}

		Map < String , List > logonMap = new HashMap < String , List > ();
		logonMap.put("logonCriteria", logonPersonType);
*/
		Map < String , List > logonMap = new HashMap < String , List > ();
		return logonMap;
	}
	
	
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws IOException{		
	//	Person person = loginService.authenticate((Person)command);
		String codeCategory =  (String) request.getParameter(CommonWebConstants.CODE_CATEGORY);
		String code =  (String) request.getParameter(CommonWebConstants.CODE_QUERY);
		//System.out.println("code is "+ request.getParameter("codeCategory"));
		List <CodeDecode> codes = new ArrayList<CodeDecode>();
		if ("SPECIALTITY".equals(codeCategory)){
			 codes = commonService.getAutoComplete(codeCategory, code);	
		}else if("table.DIAGNOSIS".equals(codeCategory)){
			codes = commonService.getDiagnosis(code);
		}else if("table.PRESCRIPTION".equals(codeCategory)){
			codes = commonService.getPrescription(code);
		}else if("table.TEST".equals(codeCategory)){
			codes = commonService.getTests(code);
		}
		
		try{
			response.flushBuffer();
			response.setContentType("text/html; charset=UTF-8");
		    PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		    out.write("{\n");
		    out.write(" query:'"+code+"',\n");
		    StringBuffer suggestions = new StringBuffer();
		    suggestions.append( "suggestions:['");
		    StringBuffer data = new StringBuffer();
		    data.append("data:['");
			for(CodeDecode eachCodeValue : codes){
				suggestions.append(eachCodeValue.getCodeDescription());
				data.append(eachCodeValue.getCodeDecode());
				suggestions.append("','");
				data.append("','");
			}			
			int poss = suggestions.lastIndexOf("','");
			suggestions.replace(poss, poss+3, "'],");
			suggestions.append("\n");
			int posd = data.lastIndexOf("','");
			data.replace(posd, posd+3, "']");
			data.append("\n");
		    //out.write(" suggestions:['Liberia','Libyan Arab Jamahiriya','Liechtenstein','Lithuania'],\n");
		    //out.write(" data:['LR','LY','LI','LT']\n");
			String suggestString = suggestions.toString();
			String dataString = data.toString();
			out.write(suggestString);
			out.write(dataString);			
		    out.write("}\n");
		    out.flush();		    
		}catch (Exception e){
			System.out.println("No Matches Found for " + codeCategory + " & " + code);
		}
		
		
		return new ModelAndView(getSuccessView());
    }
	/**
	 * @param loginService the loginService to set
	 */
	protected void onBind(HttpServletRequest request, Object command, BindException errors) throws Exception {
		Person logon = (Person) command;
		String personType = request.getParameter("hPersonType");			
		logon.setPersonTypeString(personType);
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		// TODO Auto-generated method stub
		super.onBindAndValidate(request, command, errors);
	}
	
}
