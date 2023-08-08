package com.sist.web;

import org.apache.taglibs.standard.lang.jstl.IntegerDivideOperator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	자바 
		= 데이터형 / 변수 / 연산자/ 제어문/ 배열(1차)
		= 객체지향 프로그램 (클래스/객체) 객체지향 3대 요소 (캡슐화,상속,포함,다형성)
		  *** 캡슐화 vs 은닉화
		  *** 상속 vs 포함
		  *** 오버라이딩 vs 오버로딩
		= 추상클래스/인터페이스
		  *** 추상클래스 vs 인터페이스
		  *** 인터페이스의 장점
		  
		= 예외처리
		  *** 예외처리 목적
		= 라이브러리 (java.lang , java.util)
			= Collection, 제네릭스
			  ------------------
			= IO
	
	오라클
		= DQL (SELECT) => JOIN/SubQuery
		  *** JOIN 종류
		  *** 서브쿼리의 종류
		= DML (INSERT,UPDATE,DELETE)
		= DDL (CREATE,ALTER,DROP,TRUNCATE) => 제약조건
		  *** 제약조건
		= TCL (COMMT, ROLLBACK)
		= PL/SQL (프로시저)
		  *** 프로시저와 트리거 차이점
		= JDBC (DBCP/ORM(MyBatis,JPA))
		  *** DAO vs Service
	HTML5/CSS
		  *** GET vs POST
	JavaScript (기본) => 변수(let,const) , 제어문/연산자
					 => 함수
					 => 이벤트
					 => 태그 제어(DOM)
					 => 라이브러리 (Jquery,VueJS,React)
		  *** var / let / const
		  *** 클로저
		  *** prototype
		  *** VueJS vs React			 
	JSP : 지시자(page,taglib),내장객체(request,response,session,application)
		  액션태그(<jsp:include>)
		  TagLib(<c:~~>) , EL(${})
		  MVC
		  *** MVC 구조 (동작)
	Spring : DI, AOP, MVC
		  *** DI
		  *** AOP
	---------------------------------------------------------------
			option(websocket,task,security,spring-boot)
			
	AWS : 호스팅
	
 */
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class GoodsRestController {
	@Autowired
	private GoodsService  service;
	
	@GetMapping(value = "goods/list_vue.do",produces = "text/plain;charset=UTF-8")
	public String goods_list(int page)
	{
		String result="";
		try
		{
			int curpage=page;
			Map map = new HashMap();
			map.put("start", (curpage*12)-11);
			map.put("end", (curpage*12));
			List<GoodsVO> list = service.goodsListData(map);
			int totalpage = service.goodsTotalPage();
			
			// 블록별처리
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1;
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			//JSON으로 변경
			int i=0;
			JSONArray arr = new JSONArray();
			for(GoodsVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("no", vo.getNo());
				obj.put("name", vo.getName());
				obj.put("poster", vo.getPoster());
				obj.put("price", vo.getPrice());
				
				if(i==0)
				{
					obj.put("curpage", curpage);
					obj.put("totalpage", totalpage);
					obj.put("startPage", startPage);
					obj.put("endPage", endPage);
				}
				arr.add(obj);
				i++;
			}
			result=arr.toJSONString();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return result;
	}
	
	// 상세보기
	@GetMapping(value = "goods/detail_vue.do",produces = "text/plain;charset=UTF-8")
	public String goods_detail(int no)
	{
		String result="";
		try
		{
			GoodsVO vo = service.goodsDetailData(no);
			JSONObject obj = new JSONObject();
			
			// {} => vo
			obj.put("no", vo.getNo());
			obj.put("name", vo.getName());
			obj.put("sub", vo.getSub());
			obj.put("poster", vo.getPoster());
			obj.put("price", vo.getPrice());
			obj.put("fp", vo.getFirst_price());
			obj.put("discount", vo.getDiscount());
			obj.put("delivery", vo.getDelivery());
			obj.put("account", vo.getAccount());
			String rp=vo.getPrice().replaceAll("[^0-9]", "");
			obj.put("rp", Integer.parseInt(rp));
			result=obj.toJSONString();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
}
