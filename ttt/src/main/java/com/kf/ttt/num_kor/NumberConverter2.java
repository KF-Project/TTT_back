package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 10À» ÀÔ·ÂÇÏ¸é ¿­,½Ê µÑ ´Ù Ãâ·ÂµÇ¾î¾ß ÇÔ

public class NumberConverter2 {
  private static final String[] NUMBER_NAMES = {
    "¿µ", "ÇÏ³ª", "µÑ", "¼Â", "³İ", "´Ù¼¸", "¿©¼¸", "ÀÏ°ö", "¿©´ü", "¾ÆÈ©"
  };
  private static final String[] TEN_NAMES = {
    "", "¿­", "½º¹°", "¼­¸¥", "¸¶Èç", "½®", "¿¹¼ø", "ÀÏÈç", "¿©µç", "¾ÆÈç"
  };

//  public static String pickNum(String sentence) {
//    Pattern pattern = Pattern.compile("\\d+");
//    Matcher matcher = pattern.matcher(sentence);
//
//    StringBuilder numOnly = new StringBuilder();
//
//    while (matcher.find()) {
//        numOnly.append(matcher.group());
//    }
//
//    return numOnly.toString();
//  }

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

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    int number = scanner.nextInt();

    if (number >= 10000 && String.valueOf(number).charAt(0) == '1') {
        System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo(number, true) + ")");
    } else if (number <= 99 && number > 0) {
    	System.out.println("(" + number + ")/(" + NumberConverter2.convertToKorean(number) + ")");
    }

//    System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo2(number, false) + ")");
    System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")");

    scanner.close();
  }
}
