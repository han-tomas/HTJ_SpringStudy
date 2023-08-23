package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendController {
	@GetMapping("recommend/recommend.do")
	public String recommend_page(Model model)
	{
		model.addAttribute("main_jsp","../recommend/recommend.jsp");
		return "main/main";
	}
}
