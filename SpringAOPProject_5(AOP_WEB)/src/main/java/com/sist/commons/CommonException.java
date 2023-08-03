package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// Spring : 반복코딩(X)
// 모든 Controller의 예외처리 => 전역
@ControllerAdvice // Controller에서 발생하는 에러를 한번에 처리하는 어노테이션
public class CommonException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("===============RuntimeException=================");
		ex.printStackTrace();
		System.out.println("================================================");
	}
	@ExceptionHandler(SQLException.class)
	public void runtimeException(SQLException ex)
	{
		System.out.println("===============SQLException=================");
		ex.printStackTrace();
		System.out.println("============================================");
	}
	@ExceptionHandler(IOException.class)
	public void runtimeException(IOException ex)
	{
		System.out.println("===============IOException=================");
		ex.printStackTrace();
		System.out.println("===========================================");
	}
	@ExceptionHandler(Exception.class)
	public void runtimeException(Exception ex)
	{
		System.out.println("===============Exception=================");
		ex.printStackTrace();
		System.out.println("=========================================");
	}
	

}
