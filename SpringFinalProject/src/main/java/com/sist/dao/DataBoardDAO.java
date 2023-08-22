package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
//	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
//			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
//			+ "FROM (SELECT no,subject,name,regdate,hit "
//			+ "FROM springdataboard ORDER BY no DESC)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map)
	{
		return mapper.dataBoardListData(map);
	}
	
//	@Insert("INSERT INTO springDataboard VALUES("
//			+ "sdb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},SYSDATE,0,#{filename},#{filesize},#{filecont})")
	public void dataBoardInsert(DataBoardVO vo)
	{
		mapper.dataBoardInsert(vo);
	}
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}
//	@Update("UPDATE springDataboard SET "
//			+ "hit=hit+1 "
//			+ "WHERE no=#{no}")
//	public void hitIncrement(int no);
//	
//	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
//			+ "filename,filesize,filecount "
//			+ "FROM springdataboard "
//			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
}
