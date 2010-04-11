package com.mediapp.core.common.business;

import java.util.List;

import com.mediapp.domain.common.CodeDecode;

public interface CommonService {

	public List <CodeDecode> getAutoComplete(String codeCategory,String code) ;
}
