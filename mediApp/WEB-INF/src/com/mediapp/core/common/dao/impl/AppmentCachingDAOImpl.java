package com.mediapp.core.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mediapp.core.common.dao.AppmentCachingDAO;
import com.mediapp.domain.common.CodeDecode;

public class AppmentCachingDAOImpl  extends MediAppBaseDAOImpl  implements AppmentCachingDAO {
	public List < CodeDecode > getCodeDecode() throws DataAccessException{		
		return (ArrayList<CodeDecode>) getListNoOptions("common.getCodeDecode");
	}

}
