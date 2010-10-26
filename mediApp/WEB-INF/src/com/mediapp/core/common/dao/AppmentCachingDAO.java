package com.mediapp.core.common.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mediapp.domain.common.CodeDecode;


public interface AppmentCachingDAO {
	
	public List < CodeDecode > getCodeDecode() throws DataAccessException;
}
