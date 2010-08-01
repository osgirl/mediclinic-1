package com.mediapp.web.common;
import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sun.org.apache.xml.internal.serializer.ToUnknownStream;

public class FallbackJstlViewResolver extends InternalResourceViewResolver {

	private InternalResourceViewResolver mFallBackViewResolver ;

	public View resolveViewName(String pViewName , Locale pLocale)throws Exception{
		System.out.println("ChainableJstlViewResolver "+pViewName+" "+pLocale);

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
			System.out.println("Inside If : "+lResourecePath+"Not found");
			if (mFallBackViewResolver == null){
				System.out.print("No fall back view resolver configured");
				//lView = super.resolveViewName(pViewName, pLocale);
			}else{
				System.out.print("Resolving view using fallback view resolver");
				lView = mFallBackViewResolver.resolveViewName(pViewName, pLocale);
			}

		}else{
			System.out.println("Inside Else");
			lView = super.resolveViewName(pViewName, pLocale);

		}
		System.out.println(lResourecePath);
		return lView;
	}

	public void setFallBackViewResolver(InternalResourceViewResolver pFallBackViewResolver){
		mFallBackViewResolver = pFallBackViewResolver;
	}
}


