package com.kf.ttt.service;

import org.springframework.stereotype.Service;

//핵심적인 비즈니스 로직(사용자의 요구를 처리하는 핵심로직)

@Service
public class TransService {
	
	public String engToKorean(String text){
		
		
		char[] transList = text.toUpperCase().toCharArray();
		
		String transString = "";
		

		String[] transDictionary = {
	            "에이", "비", "씨", "디", "이", "에프",
	            "지", "에이치", "아이", "제이", "케이", "엘",
	            "엠", "엔", "오", "피", "큐", "알",
	            "에스", "티", "유", "브이", "더블유", "엑스",
	            "와이", "제트"
		}; 
		
		
		for(char i : transList) {
			if(Character.isLetter(i)) {
				int index = i -'A';
				if(index >=0 && index< transDictionary.length) {
					transString += transDictionary[index];
				}else {
					transString += i;
				}
			}else {
				transString += i;
			}
		}
		
		
		return transString;
	}
}
