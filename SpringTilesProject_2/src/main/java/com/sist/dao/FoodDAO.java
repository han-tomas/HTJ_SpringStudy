package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository //메모리할당
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
//	@Select("SELECT cno,title,poster FROM food_category ORDER BY cno ASC")
	public List<CategoryVO> foodCategoryData()
	{
		return mapper.foodCategoryData();
	}
	
////	@Select("SELECT fno,name,poster,rownum "
////			+ "FROM (SELECT fno,name,poster "
////			+ "FROM food_house ORDER BY fno ASC) "
////			+ "WHERE rownum<=7")
//	public List<FoodVO> foodTop7()
//	{
//		return mapper.foodTop7();
//	}
//	
////	@Select("SELECT no,title,poster,rownum "
////			+ "FROM (SELECT no,title,poster "
////			+ "FROM seoul_location ORDER BY no ASC "
////			+ "WHERE rownum<=7")
//	public List<SeoulVO> seoulTop7()
//	{
//		return mapper.seoulTop7();
//	}
//	@Select("SELECT fno,cno,name,poster,phone,type,score "
//			+ "FROM food_house "
//			+ "WHEREcno=#{cno}")
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
//	@Select("SELECT title,subject FROM food_category "
//			+ "WHERE cno=#{cno}")
	public CategoryVO foodCategoryInfoData(int cno)
	{
		return mapper.foodCategoryInfoData(cno);
	}
}
