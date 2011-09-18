package com.mediapp.core.common.business.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.smslib.smsserver.SMSServer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.ReportPackage;
import com.mediapp.core.common.dao.AppmentCachingDAO;

public class AppmentCache implements InitializingBean {

	 /**
	  * Reference to the logger
	  */
	protected final Log logger = LogFactory.getLog(getClass());

	 /**
	  * Reference to the member variable (singleton implementation)
	  */
	 private static AppmentCache appmentCache;

	 /**
	  * Reference to the CachingServiceDAO
	  */
	 private AppmentCachingDAO appmentCachingDAO;


	public AppmentCachingDAO getAppmentCachingDAO() {
		return appmentCachingDAO;
	}

	public void setAppmentCachingDAO(AppmentCachingDAO appmentCachingDAO) {
		this.appmentCachingDAO = appmentCachingDAO;
	}

	/**
	  * Map of all lending banks
	  * Key is Bank Id and Value is LendingBank object
	  */
	 private Map < String, List <CodeDecode> >  allCodeDecode = new HashMap < String, List <CodeDecode> > ();

	private boolean reloadCacheFlag;

	private List<CodeDecode> codeDecode;
	
	private List<ReportPackage> reportPackage =new ArrayList<ReportPackage>() ;


	 /**
	  * The constructor will call the initializeCache() method
	  * to ensure that the cache is fully initialized before the reference to
	  * the cache is returned to the calling clients.
	  */
	 private AppmentCache() {
	 }

	 /**
	  * This method will be called by all the other classes to get
	  * a handler to the instance of the cache
	  * @return MyCache   - Instance of the MyCache
	  */
	 public static AppmentCache getInstance() {
	  return appmentCache;
	 }

	 /**
	  * This method will be called by the constructor of the MyCache
	  * and will be responsible for calling the required DAO methods to retrieve the
	  * data from the database that will be cached.
	  */
	 private synchronized void initializeCache() {
	  // check and prevent reload of cache if not required
	  if (null != appmentCache ) {
	   return;
	  }

	  // set the static variable to the cache instance reference
	  appmentCache = this;

	  // call the method to populate all the cache elements
	  populateCacheElements();
	  //startSMSService();
	  (new Thread(new ProcessSMS())).start();

	 }

	 private void startSMSService() {
		 //List <CodeDecode> codes = getcodeDecodeForCategory("SMSSERVER");
		 //System.setProperty(codes.get(0).getCodeDescription(), codes.get(0).getCodeDecode());
		 System.setProperty("smsserver.configfile","classpath://SMSServer.conf");
		 String[] arg = {""};
		SMSServer.main(arg);
		
	}

	 
	 public synchronized void reloadCache()  {
	  // call the method to re-populate the different data structures on the cache
	  populateCacheElements();
	  //Set reload Cache Flag to identify whether cache is reloaded
	  this.reloadCacheFlag = true;
	 }

	 /**
	  * This method is responsible for populating all the data structures on
	  * the cache
	  * 
	  */
	 private synchronized void populateCacheElements()   {
	  
	  loadCodeDecode();
	  loadReports();
	  
	  
	 }

	 /**
	  * @return the allCodeDecode
	  */
	 protected Map < String, List <CodeDecode> > getAllCodeDecode() {
	  return Collections.unmodifiableMap(allCodeDecode);
	 }


	 /**
	  * This method will be called once the variable properties are set and the constructor method is called.This
	  * methods calls the initializeCache method that is responsible for calling the method to load all the menu
	  * items in a collection variable
	  */
	 public void afterPropertiesSet() {
	  initializeCache();
	 }

	 private void loadCodeDecode() {
	  Map < String, List <CodeDecode> > codeDecodeMap = new LinkedHashMap< String, List<CodeDecode> > ();
	  List < CodeDecode > codeDecodeList = appmentCachingDAO.getCodeDecode();

	  if (null == codeDecodeList) {
	   throw new IllegalStateException("data not found!");
	  }
	  String prevCategory=null;
	  List < CodeDecode > eachCodeDecodeList = new ArrayList<CodeDecode>(); 
	  for (CodeDecode codeDecode : codeDecodeList) {
		  if(null==prevCategory || !codeDecode.getCodeCategory().equals(prevCategory)){			  
			  if(null != prevCategory){
				  codeDecodeMap.put(prevCategory, eachCodeDecodeList);
				  eachCodeDecodeList = new ArrayList<CodeDecode>();
			  }
			  prevCategory = codeDecode.getCodeCategory();
			  
		  }
		  eachCodeDecodeList.add(codeDecode);
	   
	  }
	  codeDecodeMap.put(prevCategory, eachCodeDecodeList);

	  synchronized (this.allCodeDecode) {
	   this.allCodeDecode = codeDecodeMap;
	  }
	 }

	 private void loadReports(){
		 List<ReportPackage> reportPackageList = appmentCachingDAO.getReportPackage();

		  if (null == reportPackageList) {
		   throw new IllegalStateException("data not found!");
		  }
		  synchronized (this.reportPackage) {
			   this.reportPackage = reportPackageList;
			  }

	 }
	 /**
	  * @return the loanCodeDecode
	  */
	 protected List < CodeDecode > getcodeDecode() {	  
		 return codeDecode;
	 }

	 public List < ReportPackage> getReportPackage() {	  
			return reportPackage;
	}

	 /**
	  * @param loanCodeDecode the loanCodeDecode to set
	  */
	 protected void setCodeDecode(List < CodeDecode > codeDecode) {
	  synchronized (this.codeDecode) {
	   this.codeDecode = codeDecode;
	  }
	 }

	 public List < CodeDecode > getcodeDecodeForCategory(String category) {
			return allCodeDecode.get(category);
	}

		private class ProcessSMS implements Runnable {

			public void run() {
				 List <CodeDecode> codes = getcodeDecodeForCategory("SMSSERVER");
				 System.setProperty(codes.get(0).getCodeDescription(), codes.get(0).getCodeDecode());
				 String[] arg = {""};
				SMSServer.main(arg);
			}
		}

}

