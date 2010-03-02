/**
 * 
 */
package com.mediapp.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mediapp.core.exception.common.MediAppBaseException;
import com.mediapp.web.constants.common.CommonWebConstants;
import com.mediapp.web.util.common.CommonWebUtil;

/**
 * This interceptor intercepts all the application requests 
 * @author a461353
 * 
 */
public class MediAppHandlerInterceptor extends HandlerInterceptorAdapter {

	private final Log logger = LogFactory.getLog(getClass());
	/**
	 * This method is called before servicing any url.
	 * @param request - HttpServletRequest object
	 * @param response - HttpServletResponse object
	 * @param handler - The object handler
	 * @return boolean - returns true if the requested url can be displayed else returns false
	 * @throws Exception -  incase of invalid state or arguments
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (!isAuthenticated(request)) {
			throw new MediAppBaseException("user.not.authenticated");
		} 
		return true;
	}

	private boolean isAuthenticated(HttpServletRequest request) { 
		String requestURI = "";
		requestURI = request.getRequestURI();
		boolean result = true;
		if (!requestURI.equals(CommonWebConstants.LOGIN_URL) && !requestURI.equals(CommonWebConstants.WELCOMEPAGE_URL)) {
			result = CommonWebUtil.getUser(request).isAuthenticated();
		}
		logger.info("requestURI = " + requestURI + " result = " + result);
		return result;
	}
}
