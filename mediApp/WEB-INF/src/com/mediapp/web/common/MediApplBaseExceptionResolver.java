/**
 * 
 */
package com.mediapp.web.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

/**
 * This class is the generic exception resolver that will be used to handle exceptions
 * that propogate through to the presentation layer of the applicaion. This class will
 * be responsible for logging the exception and redirecting the response to an error
 * page.
 *
 */
public class MediApplBaseExceptionResolver extends SimpleMappingExceptionResolver {
	
	private final Log logger = LogFactory.getLog(getClass());
	/**
	 * This method will get invoked on encountering exceptions in the Spring
	 * MVC Controllers in the application
	 * @param request - The HttpServletRequest object
	 * @param response - The HttpServletResponse object
	 * @param handler - The exception handler
	 * @param ex - The exception that was encountered
	 * @return ModelAndView - The ModelAndView to be returned
	 *                        (generic error view)
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		logger.info("Exception is " + ex.getMessage());
		List<String> errorList = new ArrayList<String>();
		errorList.add(ex.getMessage());
		CommonWebUtil.addErrorMessagesInReq(request, errorList);
		return new ModelAndView("redirect:/welcomePage.htm",CommonWebConstants.USER_ID, CommonWebUtil.getUser(request));
	}

}
