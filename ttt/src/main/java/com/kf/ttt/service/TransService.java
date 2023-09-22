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

		//String은 변경이 불가능한 문자열을 생성, 새로운 문자열을 생성하면 이전 문자열은 가비지컬렉터로 들어간다
		//메모리를 많이 잡아먹게 될 수 있음.
		//StringBuilder는 변경이 가능한 문자열을 생성, 따라서 String을 합치는 작업시 하나의 대안이 될 수 있다. 
        StringBuilder transString = new StringBuilder();
        
        
        String[] words = text.split("\\s+"); 
        
        
        //공백을 기준으로 문자열을 나눈 후 조사 분리 방법 고민할 것. 
        for (String word : words) {
            if (word.matches(".*[a-zA-Z].*")) { 
            	
                StringBuilder translatedWord = new StringBuilder();
                
                for (char letter : word.toUpperCase().toCharArray()) {
                    if (Character.isLetter(letter)) {
                        String translation = transDictionary.get(letter);
                        if (translation != null) {
                            translatedWord.append(translation);
                        } else {
                            translatedWord.append(letter);
                        }
                    } else {
                        translatedWord.append(letter);
                    }
                }
                transString.append("(").append(word).append(")/(").append(translatedWord.toString()).append(") ");
            } else {
                transString.append(word).append(" ");
            }
        }

        return transString.toString();
    }
}






//	public String engToKorean(String text) {
//
//		char[] transList = text.toUpperCase().toCharArray();
//
//		StringBuilder transString = new StringBuilder();
//
//		for (char letter : transList) {
//			if (Character.isLetter(letter)) {
//				String translation = transDictionary.get(letter);
//				
//				System.out.println(translation);
//				
//				if (translation != null) {
//					transString.append(translation);
//					System.out.println("합1"+transString);
//				} else {
//					transString.append(letter);
//					System.out.println("합2"+transString);
//				}
//			} else {
//				transString.append(letter);
//				System.out.println("합3"+transString);
//			}
//		}
//
//		System.out.println("("+text +")/("+transString.toString()+")");
//		String result = "("+text+")/("+transString.toString() +")";
//		
//		return result;
//	}