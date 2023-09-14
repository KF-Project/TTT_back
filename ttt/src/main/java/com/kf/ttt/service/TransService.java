package com.kf.ttt.service;

import java.util.List;

import org.springframework.stereotype.Service;

//핵심적인 비즈니스 로직(사용자의 요구를 처리하는 핵심로직)

@Service
public class TransService {
	
	public List<String> engToKorean(String text){
		
		String transString = "";
		
		char[] transList = text.toUpperCase().toCharArray();
		
		String[] transDictionary = {
	            "에이", "비", "씨", "디", "이", "에프",
	            "지", "에이치", "아이", "제이", "케이", "엘",
	            "엠", "엔", "오", "피", "큐", "알",
	            "에스", "티", "유", "브이", "더블유", "엑스",
	            "와이", "제트"
	        }; 
		
		
		return null;
	}
}
