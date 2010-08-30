package com.mediapp.web.taglibs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;
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
   * @throws JspException - JspException is thrown if any
   */
  public int doStartTag() throws JspException  {
	   try {
			  
		   	Map menuItems = (Map) pageContext.getSession().getAttribute("menuItems");
			Person person   = (Person) pageContext.getSession().getAttribute("person");
			Iterator it = menuItems.entrySet().iterator();
			StringBuffer menuItemTag = new StringBuffer("");
			//StringBuffer menuItemTag = new StringBuffer("<%Person q = (Person)request.getSession().getAttribute('person');if(null != q.getLastName()&& !''.equal(q.getLastName())){%>");
			 // menuItemTag = menuItemTag
			 //  .append(CommonWebConstants.MENU_TABLE_START_TAG);
			if(null == person.getLastName() || "".equals(person.getLastName())){
				 menuItemTag = menuItemTag.append(CommonWebConstants.VERTICAL_MENU_BUTTON_TAG)
		          .append(CommonWebConstants.QUOTES)
		          .append("/personalProfile.htm")
		          .append(CommonWebConstants.QUOTES)
		          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_ONCLICK_TAG)
		          .append("Personal Profile")
		          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_VALUE_TAG);
			}else {	
			     while (it.hasNext()) { 
			         Map.Entry pairs = (Map.Entry)it.next();         
			         menuItemTag = menuItemTag
			          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_TAG)
			          .append(CommonWebConstants.QUOTES)
			          .append(pairs.getValue())
			          .append(CommonWebConstants.QUOTES)
			          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_ONCLICK_TAG)
			          .append(pairs.getKey())
			          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_VALUE_TAG);
			    //     System.out.println(pairs.getKey() + " = " + pairs.getValue()); 
			     }  
			}
			 /*    menuItemTag = menuItemTag.append("<%}else{%>").append(CommonWebConstants.VERTICAL_MENU_BUTTON_TAG)
		          .append(CommonWebConstants.QUOTES)
		          .append("/personalProfile.htm")
		          .append(CommonWebConstants.QUOTES)
		          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_ONCLICK_TAG)
		          .append("Personal Profile")
		          .append(CommonWebConstants.VERTICAL_MENU_BUTTON_AFTER_VALUE_TAG);
		       */   

			 //    menuItemTag = menuItemTag
			 // .append(CommonWebConstants.MENU_TABLE_END_TAG);
			     pageContext.getOut().print(menuItemTag.toString());
			  
	   		}catch(Exception se){
	   			System.out.println(se.toString());
	   			System.err.println("stacktrace"+se);
	   		} 
	   return 0;
	   }
	  public int doEndTag() throws JspException {
	   return EVAL_PAGE; // other return: SKIP_PAGE
	  }
	  
}