package com.mediapp.web.taglibs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class VerticalMenuTag  extends TagSupport {
	/**
	  * Declaring Class variable for the serialVersionUID
	  */
	 private static final long serialVersionUID = 8800670293986693386L;

	 /**
	  * The doStartTag method is executed when the tag is started. The doStartTag method assumes that the properties pageContext
	  * and parent have been set. It also assumes that any properties exposed as attributes have been set too.
	  * When this method is invoked, the body has not yet been evaluated. This method returns Tag.EVAL_BODY_INCLUDE
	  * to indicate that the body of the action should be evaluated or SKIP_BODY to indicate otherwise. When a Tag returns
	  * EVAL_BODY_INCLUDE the result of evaluating the body (if any) is included into the current "out" JspWriter as
	  * it happens and then doEndTag() is invoked.
	  * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	  * @return EVAL_BODY_INCLUDE - returning this value implies that it allows body text (including JSP code)
	  *                             between the start and end tags.If it returns SKIP_BODY it implies that it ignores the
	  *                             body text. Any text between the start and end tags is not evaluated or displayed.
	  * @throws CashAvailBaseException - CashAvailBaseException is thrown if any
	  * @throws JspException - JspException is thrown if any
	  */
	 public int doStartTag() throws JspException  {
	  try {
		Map menuItems = (Map) pageContext.getSession().getAttribute("menuItems");
		Iterator it = menuItems.entrySet().iterator();
	    while (it.hasNext()) { 
	        Map.Entry pairs = (Map.Entry)it.next();	        
	        System.out.println(pairs.getKey() + " = " + pairs.getValue()); 
	    } 			
		
	  }catch(Exception e){
	  }
	  return 0;
	  }

}
