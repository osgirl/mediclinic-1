package com.mediapp.core.common.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author A461353
 *
 */
public class MediAppBaseDAOImpl extends SqlMapClientDaoSupport{
	
	private SqlMapClient sqlMapClientLocal;
	
	protected final Log logger = LogFactory.getLog(getClass());
	/**
	 * Returns single Object
	 * @param operationName
	 * @param criteria
	 * @return
	 */
	public void getObject() {
		System.out.println("#Get Selected Market DAO#");
		Integer count =(Integer) getSqlMapClientTemplate().queryForObject("getCount",null);
		System.out.println("Count is" + count);
	}
	

	public SqlMapClient getSqlMapClientLocal() {
		return sqlMapClientLocal;
	}

	public void setSqlMapClientLocal(SqlMapClient sqlMapClientLocal) {
		this.sqlMapClientLocal = sqlMapClientLocal;
	}

}
