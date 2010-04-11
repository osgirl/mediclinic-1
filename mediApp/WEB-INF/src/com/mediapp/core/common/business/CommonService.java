package com.mediapp.core.common.business;

import java.util.List;

import com.mediapp.domain.common.CodeDecode;
import com.mediapp.domain.common.SearchCriteria;
import com.mediapp.domain.common.SearchResult;

public interface CommonService {

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) ;
	
	public List <SearchResult> getDoctors(SearchCriteria searchCriteria);
}
