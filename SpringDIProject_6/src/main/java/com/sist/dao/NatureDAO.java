package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.SeoulNatureVO;

public class NatureDAO extends SqlSessionDaoSupport{
	public List<SeoulNatureVO> natureListData()
	{
		return getSqlSession().selectList("natureListData");
	}

}
