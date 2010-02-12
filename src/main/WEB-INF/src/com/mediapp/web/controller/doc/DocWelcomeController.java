package com.mediapp.web.controller.doc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DocWelcomeController implements Controller{
	
	 private final Log logger = LogFactory.getLog(getClass());

	 public ModelAndView handleRequest(HttpServletRequest request,
	            HttpServletResponse response) {
	        Map model = new HashMap();
	        logger.info("Doctor page called... ");
	        return new ModelAndView("docProfile", "model", model);
	    }
}
