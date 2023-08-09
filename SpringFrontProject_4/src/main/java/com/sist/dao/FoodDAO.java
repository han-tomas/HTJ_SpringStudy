package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
//	@Select({"<script>"
//			+ "SELECT cno,title,subject,poster "
//			+ "FROM food_category "
//			+ "WHERE "
//			+ "<if text='cno==1'>"
//			+ "cno BETEEEN 1 AND 12"
//			+ "</if>"
//			+ "<if text='cno==2'>"
//			+ "cno BETEEEN 13 AND 18"
//			+ "</if>"
//			+ "<if text='cno==3'>"
//			+ "cno BETEEEN 19 AND 30"
//			+ "</if>"
//			+ "ORDER BY cno ASC"
//			+ "</script>"
//			})
	public List<CategoryVO> foodCategoryListData(Map map)
	{
		return mapper.foodCategoryListData(map);
	}
//	@Select("SELECT fno,name,poster,type,phone,address "
//			+ "FROM food_house "
//			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
}
