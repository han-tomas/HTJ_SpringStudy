package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		List<EmpVO> list = dao.empListData();
//		dao.empListData();
//		dao.empDetailData(7788);
		dao.empFindData("A");
	}

}
