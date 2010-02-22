/**
 * 
 */
package com.mediapp.web.controller.common;

import javax.servlet.ServletException;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.mediapp.core.common.dao.impl.MediAppBaseDAOImpl;

/**
 * @author A461353
 *
 */
public class LoginController extends MediAppBaseController {

	MediAppBaseDAOImpl dao;
	public ModelAndView onSubmit(Object command) throws ServletException {
        //return new ModelAndView(new RedirectView());
		return new ModelAndView(getSuccessView());
    }
	/**
	 * @param dao the dao to set
	 */
	public void setDao(MediAppBaseDAOImpl dao) {
		this.dao = dao;
		dao.testDBConnectivity();
	}
	
}
