package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
@Aspect //메모리 할당용 어노테이션이 아니다!!!
@Component
public class footerAspect {
	@Autowired
	private AspectDAO dao;
//												 -모든메소
	@After("execution(* com.sist.web.*Controller.*(..))")
//												  ---- 매개변수 상관없다.
	public void footerData()
	{
		// => 매개변수에 값을 채워준다(DispatcherServlet)
		// => @Controller, @RestController에서만 가능
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		List<FoodVO> fList=dao.foodTop7Data();
		List<String> sList = dao.seoulTop7Data();
		List<String> rList = dao.recipeTop7Data();
		
		request.setAttribute("flist", fList);
		request.setAttribute("sList", sList);
		request.setAttribute("rList", rList);
	}
}
