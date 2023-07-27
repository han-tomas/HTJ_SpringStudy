package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.BoardVO;
//메모리할당
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	//list.do?curpage=
	// 목록
	@GetMapping("list.do")
	public String board_list(String page,Model model)
	{
		//Model model => 전송 객체(request대신 사용)
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list = dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("list",list);
		return "board/list";
	}
	// 데이터 추가
	@GetMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	// 데이터 추가 (처리)
	@PostMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	// 데이터 수정
	// 데이터 삭제
	// 상세보기
	/*
		class Model
		{
			HttpServletRequest request;
			public void addAttribute(String key,Object obj)
			{
				request.setAttribute(key,obj);
			}
		}
		
	 */
	@GetMapping("detail.do")
	public String board_detail(int no, Model model)
	{
		//String no = request.getParameter("no")
		BoardVO vo = dao.boardDetailData(no);
		model.addAttribute("vo",vo);
		return "board/detail";
	}
	// 검색 ==> 동적 쿼리
	
}
