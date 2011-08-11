package com.mediapp.web.controller.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mediapp.core.common.business.CommonService;
import com.mediapp.core.common.business.impl.AppmentCache;
import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.MultiPartFileUploadBean;
import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;

public class MultiPartFileUploadController extends SimpleFormController {
    private static  String destinationDir = null;
	CommonService commonService;
	
	
	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	AppmentCache appmentCache;
	
	public AppmentCache getAppmentCache() {
		return appmentCache;
	}
	public void setAppmentCache(AppmentCache appmentCache) {
		this.appmentCache = appmentCache;
	}


    
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors)throws Exception {
		List <CodeDecode> codes = commonService.getCodeDecode("REPORTTYPES");
		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		int idPerson = sessionPerson.getIdPerson(); 
		MultiPartFileUploadBean bean = new MultiPartFileUploadBean();
		bean.setIdPatient(commonService.getPatientDetails(idPerson).getIdPatient());
		Map < String , Object > rtnMap = new HashMap < String , Object > ();
		rtnMap.put("DocumentType", codes);
		rtnMap.put("fileUpload",bean);
		return rtnMap;
	}
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, 
                                    HttpServletResponse res, 
                                    Object command, 
                                    BindException errors) throws Exception {
        if (!(request instanceof MultipartHttpServletRequest)) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Expected multipart request");
            return null;
        }
        MultiPartFileUploadBean bean = (MultiPartFileUploadBean) command;
        MultipartFile file  = bean.getFile();
 		Person sessionPerson = (Person) request.getSession().getAttribute(CommonWebConstants.USER_ID);
		int idPerson = sessionPerson.getIdPerson(); 
        bean.setFilePath(bean.getFileName());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();		
        bean.setFilePath(idPerson+dateFormat.format(date)+file.getOriginalFilename());
        destinationDir = appmentCache.getcodeDecodeForCategory("FILESTORAGE").get(0).getCodeDecode();
        File destination = new File(destinationDir + idPerson+dateFormat.format(date)+file.getOriginalFilename());
        file.transferTo(destination);
        commonService.insertPatientDocumentDetials(bean);
//        res.getWriter().write("Success, wrote to " + destination.getAbsolutePath());        
 //       res.flushBuffer();
        return new ModelAndView("redirect:/pastHistory.htm");
    }
    

}
