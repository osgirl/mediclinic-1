package com.mediapp.web.controller.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

public class LogoutController extends MediAppBaseController {
 
 protected Map referenceData(HttpServletRequest request, Object command, Errors errors)
 throws Exception {
  request.getSession().invalidate();
  return null;
 }

 public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) {
  return new ModelAndView(getSuccessView());
    }
}
 
