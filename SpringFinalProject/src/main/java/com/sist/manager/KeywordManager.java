package com.sist.manager;

import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;

public class KeywordManager {
	public static void main(String[] args) {
		
		String keyword="카이세도는 브라이튼에서 수준급 중원 자원으로 성장했고 팀 최초의 유럽축구연맹(UEFA) 유로파리그(UEL) 진출을 이끌었다. 에콰도르 대표팀 일원으로 카타르 월드컵까지 출전하면서 경험까지 장착했다.";
		KeywordExtractor ke = new KeywordExtractor();
		KeywordList list = ke.extractKeyword(keyword, true);
		
		for(int i=0;i<list.size();i++)
		{
			Keyword wrd = list.get(i);
			System.out.println(wrd.getString()+":"+wrd.getCnt());
		}
	}
}
