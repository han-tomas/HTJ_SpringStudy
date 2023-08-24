package com.sist.web;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.FoodDAO;
import com.sist.manager.NaverDataManager;
import com.sist.vo.FoodVO;

@RestController
public class RecommendRestController {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private NaverDataManager ndm;
	private String[] type1= {"봄", "여름", "가을", "겨울", "맑은날", "추운날", "흐린날" ,"비오는날", "더운날","눈오는날"};
	private String[] type2= {"외로운 날", "기분전환", "슬픈 날", "이별하는 날" ,"지칠는 날", "위로 받고 싶은 날" ,"짜증나는 날",  "우울한 날",
	 "행복한 날", "불안한 날" , "기쁜 날", "축하받고 싶은 날"};
	private String[] type3= {"밝은 날", "신나는 날", "따뜻한 날", "편안한 날", "달콤한 날", "시원한 날" ,  "어두운 날"};
	
	@GetMapping(value = "recommend/recommend_sub_vue.do",produces = "text/plain;charset=UTF-8")
	public String recommend_sub(int no) throws Exception
	{
		List<String> list = new ArrayList<String>();
		if(no==1)
		{
			list=Arrays.asList(type1);
		}
		else if(no==2)
		{
			list=Arrays.asList(type2);
		}
		else if(no==3)
		{
			list=Arrays.asList(type3);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value = "recommend/recommend_vue.do",produces = "text/plain;charset=UTF-8")
	public String recommend_list(String fd) throws Exception
	{
		String json=ndm.foodRecommend(fd);
		List<String> list = ndm.jsonParser(json);
		//블로그 댓슬
		List<String> nList=dao.foodNameGetData(fd);
		// 정규식
		Pattern[] p = new Pattern[nList.size()];
		int[] count = new int[nList.size()];
		
		for(int i=0;i<p.length;i++)
		{
			p[i]=Pattern.compile(nList.get(i));
		}
		// 적용
		Matcher[] m= new Matcher[nList.size()];
		for(String s:list)
		{
			for(int i=0;i<m.length;i++)
			{
				m[i]=p[i].matcher(s);
				if(m[i].find())
				{
					String data=m[i].group();
					count[i]++;
				}
			}
		}
		List<FoodVO> fList= new ArrayList<FoodVO>();
		for(int i=0;i<nList.size();i++)
		{
			String name=nList.get(i);
			if(count[i]>1)
			{
				System.out.println(name+" : "+count[i]);
				FoodVO vo =dao.foodRecommendInfoData(name);
				String poster=vo.getPoster();
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				vo.setPoster(poster);
				fList.add(vo);
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		String ss = mapper.writeValueAsString(fList);
		return ss;
		
	}
}
