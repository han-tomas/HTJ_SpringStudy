package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@Autowired
	private BCryptPasswordEncoder encoder; // 암호화/복호화
	
	@GetMapping("member/login.do")
	public String member_login()
	{
		return "member/login"; // login_ok => vue (MemberRestController)
	}
	@GetMapping("member/join.do")
	public String member_join()
	{
		return "member/join"; // join_ok => MemberRestController
	}
	@GetMapping("member/logout.do")
	public String member_logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:../member/login.do";
	}
	
}
