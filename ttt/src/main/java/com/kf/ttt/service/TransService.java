package com.kf.ttt.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

//핵심적인 비즈니스 로직(사용자의 요구를 처리하는 핵심로직)

@Service
public class TransService {

	private Map<Character, String> transDictionary = new HashMap<>();

	public TransService() {
		transDictionary.put('A', "에이");
		transDictionary.put('B', "비");
		transDictionary.put('C', "씨");
		transDictionary.put('D', "디");
		transDictionary.put('E', "이");
		transDictionary.put('F', "에프");
		transDictionary.put('G', "지");
		transDictionary.put('H', "에이치");
		transDictionary.put('I', "아이");
		transDictionary.put('J', "제이");
		transDictionary.put('K', "케이");
		transDictionary.put('L', "엘");
		transDictionary.put('M', "엠");
		transDictionary.put('N', "엔");
		transDictionary.put('O', "오");
		transDictionary.put('P', "피");
		transDictionary.put('Q', "큐");
		transDictionary.put('R', "알");
		transDictionary.put('S', "에스");
		transDictionary.put('T', "티");
		transDictionary.put('U', "유");
		transDictionary.put('V', "브이");
		transDictionary.put('W', "더블유");
		transDictionary.put('X', "엑스");
		transDictionary.put('Y', "와이");
		transDictionary.put('Z', "제트");

	}

	public String engToKorean(String text) {

		char[] transList = text.toUpperCase().toCharArray();

		StringBuilder transString = new StringBuilder();

		for (char letter : transList) {
			if (Character.isLetter(letter)) {
				String translation = transDictionary.get(letter);
				
				System.out.println(translation);
				
				if (translation != null) {
					transString.append(translation);
					System.out.println("합1"+transString);
				} else {
					transString.append(letter);
					System.out.println("합2"+transString);
				}
			} else {
				transString.append(letter);
				System.out.println("합3"+transString);
			}
		}

		System.out.println("("+text +")/("+transString.toString()+")");
		String result = "("+text+")/("+transString.toString() +")";
		
		return result;
	}
}
