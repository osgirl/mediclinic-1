package com.mediapp.web.common;
import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sun.org.apache.xml.internal.serializer.ToUnknownStream;

public class FallbackJstlViewResolver extends InternalResourceViewResolver {

	private InternalResourceViewResolver mFallBackViewResolver ;

	public View resolveViewName(String pViewName , Locale pLocale)throws Exception{
		View lView =null; 
		boolean redirectExists= pViewName.toUpperCase().contains("REDIRECT:");
		int redirectIndex =pViewName.indexOf("/");
		int dotIndex =pViewName.lastIndexOf(".");		
		String lResourecePath=null;
		if (redirectExists){
			String removeRedirect =pViewName.substring(redirectIndex+1,dotIndex);
			lResourecePath = getPrefix()+removeRedirect+getSuffix();
		}else{
			lResourecePath = getPrefix()+pViewName+getSuffix();	
		}
		
		if (!getApplicationContext().getResource(lResourecePath).exists()){			
			if (mFallBackViewResolver == null){
			//	System.out.print("No fall back view resolver configured");
				//lView = super.resolveViewName(pViewName, pLocale);
			}else{
				lView = mFallBackViewResolver.resolveViewName(pViewName, pLocale);
			}

		}else{
			lView = super.resolveViewName(pViewName, pLocale);

		}
	//	System.out.println(lResourecePath);
		return lView;
	}

	public void setFallBackViewResolver(InternalResourceViewResolver pFallBackViewResolver){
		mFallBackViewResolver = pFallBackViewResolver;
	}
}


