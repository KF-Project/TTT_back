package com.kf.ttt.service;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class SymbolTransService {

	public static HashMap<String, String[]> map = new HashMap<String, String[]>();

	static String[] plus = { "더하기", "플러스" };
	static String[] minus = { "빼기", "마이너스", "다시" };
	static String[] multi = { "곱하기", "애스태리커" };
	static String[] divide = { "나누기", "분의" };

	static {
		map.put("+", plus);
		map.put("-", minus);
		map.put("*", multi);
		map.put("/", divide);
	}

	 
	public static String specialSymbolTrans(String text) {
		String[] transLation = map.get(text);
		
		//숫자 및 문자 그리고 일부 특수문자(,.그리고 띄어쓰기)를 제외한 모든 특수문자 변경
		return Arrays.toString(transLation).replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9,. ]", ""); 
	}

//	public static void main(String args[]) {
//
//		Scanner scanner = new Scanner(System.in);
//		System.out.println(scanner);
//
//		String scanResult = scanner.nextLine();
//
//		specialSymbolTrans(scanResult);
//		
//		//결과값이 더하기,플러스 형태로 출력
//		System.out.println(specialSymbolTrans(scanResult));
//		
//		scanner.close();
//	}
}
