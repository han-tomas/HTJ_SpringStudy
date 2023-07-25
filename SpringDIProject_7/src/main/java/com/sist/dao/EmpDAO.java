package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository("dao")
public class EmpDAO {
	@Autowired // getBean 대신에 사용
	private EmpMapper mapper;
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
	public EmpVO empDetailData(int empno)
	{
		return mapper.empDetailData(empno);
	}
	public List<EmpVO> empFindListData(String ename)
	{
		return mapper.empFindListData(ename);
	}
}
