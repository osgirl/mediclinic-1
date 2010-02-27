/**
 * 
 */
package com.mediapp.core.common;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

/**
 * Spring AOP Interceptor that will be used for generic exception handling
 * in the 'Business Service' layer of the application.
 * @author A461353
 *
 */
public class MediAppExceptionInterceptor implements ThrowsAdvice {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	public void afterThrowing(Method method, Object[] args, Object target, Throwable ex)
	{
		logger.info(" In MediAppExceptionInterceptor with method = " + method
				+ " error = " + ex);
	}

}
