package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodCategoryDAO;
import com.sist.dao.FoodCategoryVO;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		FoodCategoryDAO dao = (FoodCategoryDAO)app.getBean("fcdao");
		List<FoodCategoryVO> list = dao.foodCategoryListData();
		for(FoodCategoryVO vo:list)
		{
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
	}

}
