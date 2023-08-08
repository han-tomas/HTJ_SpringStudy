package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
	@GetMapping("goods/list.do")
	public String goods_list()
	{
		return "goods/list";
		
	}
	@GetMapping("goods/detail.do")
	public String goods_detail(int no, Model model)
	{
		model.addAttribute("no",no);
		return "goods/detail";
	}
}
