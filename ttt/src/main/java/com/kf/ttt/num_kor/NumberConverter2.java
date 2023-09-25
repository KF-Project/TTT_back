package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 10을 입력하면 열,십 둘 다 출력되어야 함

public class NumberConverter2 {
  private static final String[] NUMBER_NAMES = {
    "영", "하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덟", "아홉"
  };
  private static final String[] TEN_NAMES = {
    "", "열", "스물", "서른", "마흔", "쉰", "예순", "일흔", "여든", "아흔"
  };


  public static String convertToKorean(int number) {
    if (number >= 0 && number <= 99) {
      int ten = number / 10;
      int one = number % 10;

      String tenName = TEN_NAMES[ten];
      String oneName = NUMBER_NAMES[one];

      if (ten == 0) {
          return oneName;
      } else if (one == 0) {
          return tenName;
      } else {
          return tenName + oneName;
      }
    } else {
        return "";
    }
    
  }

//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    
//    String input = scanner.nextLine();
//    
//    Pattern pattern = Pattern.compile("\\d+");
//    Matcher matcher = pattern.matcher(input);
//    
//    if (matcher.find()) {
//    	
//        int number = Integer.parseInt(matcher.group());
//        
//        if (number >= 10000 && String.valueOf(number).charAt(0) == '1') {
//        	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo(number, true) + ")"));
//        } else if (number <= 99 && number > 0) {
//        	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter2.convertToKorean(number) + ")"));
//        } 
////        else 
////        	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")"));
//        
//        System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")"));
//    }
//
//    scanner.close();
//  }
}
