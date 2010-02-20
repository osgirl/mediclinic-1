/**
 * 
 */
package com.mediapp.web.controller.common;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;

import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;


public class WelcomeController extends MediAppBaseController {
	private MediAppBaseDAOImpl mediAppBaseDAOImpl;
	public ModelAndView onSubmit(Object command) throws ServletException {
        //return new ModelAndView(new RedirectView());
		return new ModelAndView(getSuccessView());
    }
	
	protected Map referenceData(HttpServletRequest request, Object Command, Errors error) throws Exception{
			mediAppBaseDAOImpl.getObject();
		return null;
		
	}

	public MediAppBaseDAOImpl getMediAppBaseDAOImpl() {
		return mediAppBaseDAOImpl;
	}

	public void setMediAppBaseDAOImpl(MediAppBaseDAOImpl mediAppBaseDAOImpl) {
		this.mediAppBaseDAOImpl = mediAppBaseDAOImpl;
	}

}
