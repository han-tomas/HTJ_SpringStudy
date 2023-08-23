package com.sist.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
// 공통예외처리
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("============= RuntimeException 발생 =============");
		ex.printStackTrace();
		System.out.println("================================================");
		
	}
	// IOException , SqlException, Exception
	@ExceptionHandler(IOException.class)
	public void IOException(IOException e)
	{
		System.out.println("============= IOException 발생 =============");
		e.printStackTrace();
		System.out.println("================================================");
	}
}
