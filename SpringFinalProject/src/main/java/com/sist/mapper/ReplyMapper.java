package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyVO;
public interface ReplyMapper {
	@Select("SELECT /*+ INDEX_DESC(springReply srp_no_pk) */ no, fno, id, name, msg, TO_CHAR(regdate, 'yyyy\"년\" mm\"월\" dd\"분\" hh24\"시\" mi\"분\"') AS dbday "
	        + "FROM springReply "
	        + "WHERE fno = #{fno}")
	public List<ReplyVO> replyListData(int fno);
	
	@Insert("INSERT INTO springReply VALUES("
			+ "srp_no_seq.nextval,#{fno},#{id},#{name},"
			+ "#{msg},SYSDATE)")
	public void replyInsert(ReplyVO vo);
	@Delete("DELETE FROM springReply WHERE no=#{no}")
	public void replayDelete(int no);
	@Update("UPDATE springReply SET msg=#{msg} WHERE no=#{no}")
	public void replyUpdate(ReplyVO vo);
}
