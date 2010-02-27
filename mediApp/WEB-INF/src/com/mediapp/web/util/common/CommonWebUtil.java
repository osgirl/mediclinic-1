package com.mediapp.web.util.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mediapp.domain.common.Person;
import com.mediapp.web.constants.common.CommonWebConstants;

public class CommonWebUtil {

	/**
	 * Adds error messages in Request, which can be displayed including displayErrorMessage.jsp
	 * @param request
	 * @param errorList
	 */
	public static void addErrorMessagesInReq(HttpServletRequest request, List < String > errorList) {
		List< String > existingList = (List< String >) request.getAttribute("errorMessageList");
		if (existingList != null && !existingList.isEmpty()) {
			errorList.addAll(existingList);
		}
		request.setAttribute("errorMessageList", errorList);
	}
	
	/**
	 * This method is used to set attribute in session
	 * @param request -
	 * @param attributeName -
	 * @param attributeValue -
	 */
	public static void setSessionAttribute(HttpServletRequest request, String attributeName, Object attributeValue) {

		HttpSession session = request.getSession(false);
		if (null != session && null != attributeValue) {
			session.setAttribute(attributeName, attributeValue);
		}

	}
	/**
	 * This request is used to get attribute from the session
	 * @param request -
	 * @param attributeName -
	 * @return
	 */
	public static Object getSessionAttribute(HttpServletRequest request, String attributeName) {

		HttpSession session = request.getSession(false);
		Object attributeValue = null;
		if (null != session ) {
			attributeValue = session.getAttribute(attributeName);
		}
		return attributeValue;
	}
	
	/**
	 * returns the Person object from Session
	 * @param request
	 * @return - Person object if exists in session or new object
	 */
	public static Person getUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Person person = null;
		if (null != session ) {
			person = (Person) session.getAttribute(CommonWebConstants.USER_ID);
		}
		if (null == person) {
			person = new Person();
			person.setAuthenticated(false);
		}
		return person;
	}
}
