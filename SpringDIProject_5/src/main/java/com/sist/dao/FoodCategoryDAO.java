package com.sist.dao;
import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FoodCategoryDAO extends SqlSessionDaoSupport{
	public List<FoodCategoryVO> foodCategoryListData()
	{
		return getSqlSession().selectList("foodCategoryListData");
	}
}
