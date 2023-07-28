package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
	@Controller
		=> 요청 처리 후 => 요청한 결과값을 전송 => 페이지(파일)지정
		jsp(forward) = request를 전송 / .do (sendRedirect) = request를 전송하지 않고
														   기존의 파일로 이동(이동하는 화면이 다를때)
		detail.do => detail.jsp(같다)   insert_ok.do => list.do(다르다)												   
									   update_ok.do => detail.do
	@RestController
		=> 요청 처리 후 => 요청한 결과값을 전송 => 결과값만 전송
										  ---------
										  => 자바 스크립트, 일반 문자열
										  => JSON (Vue,React)
 */
@RestController
@RequestMapping("board/")
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@PostMapping(value = "update_ok.do",produces = "text/html;charset=UTF-8")
	// ModelAttribute
	/*
	 	Spring 
	 		Model(Controller) 메소드
	 		= 리턴형 
	 			String/void
	 		= 매개변수
	 			단일 변수 (int, String ...)
	 			VO 객체
	 			List
	 			[](배열)
	 			=> Model , RedirectAttribute, HttpSession
	 					   ----------------- 전송 객체(sendRedirect)
	 			   ----- 전송객체(forward)
	 		= request를 사용하지 않는다.
	 			1) request.getParameter() : 매개변수(DispatcherServlet에서
	 											  request.getParameter()한 다음에
	 											  매개변수로 값을 전송)
	 		= request대신 Model을 이용해서 request에 단긴 데이터를 JSP에 전송									
	 		
	 */
	// => 크롬에서만 가능
	/*
		Ajax, Vue , React => BoardVO List
								|	   |
								|	  JSON Array
							  JSON Object
	 */
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck = dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}
		else
		{
			result ="<script>"
					+ "alert(\"비밀번호가 틀립니다\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
	
	
}
