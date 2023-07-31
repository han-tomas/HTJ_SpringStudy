package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface SeoulMapper {
	// 명소 출력
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_location ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulLocationListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
	public int seoulLocationTotalPage();
	
	// Nature
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_nature ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulNatureListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature")
	public int seoulNatureTotalPage();
	
	// Shop
	@Select("SELECT no,title,poster,num "
			+ "FROM (SELECT no,title,poster,rownum as num "
			+ "FROM (SELECT no,title,poster "
			+ "FROM seoul_shop ORDER BY no ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulShopListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_shop")
	public int seoulShopTotalPage();
	
}
