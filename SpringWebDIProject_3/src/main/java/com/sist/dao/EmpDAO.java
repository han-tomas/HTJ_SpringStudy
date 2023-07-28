package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
/*
	@Autowired
		CONSTRUCTOR, FIELD, METHOD, PARAMETER
	class A
	{
	    @Autowired => FIELD
		private B b;
		
		@Autowired => CONSTRUCTOR
		public A(B b){}
		
		@Autowired => METHOD
		public void setB(B b){}
	}	
 */
@Repository
public class EmpDAO extends SqlSessionDaoSupport{
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<String> empGetNameData()
	{
		return getSqlSession().selectList("empGetNameData");
	}
	public List<EmpVO> empInfoData(Map map)
	{
		return getSqlSession().selectList("empInfoData",map);
	}
}
