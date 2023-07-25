package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
import com.sist.vo.*;
public class LocationDAO extends SqlSessionDaoSupport{
	public List<SeoulLocationVO> locationListData()
	{
		return getSqlSession().selectList("locationListData");
	}
	public SeoulLocationVO locationDetailData(int no)
	{
		return getSqlSession().selectOne("locationDetailData",no);
	}
}
