package com.kf.ttt.num_kor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.kf.ttt.entity.Num;
import com.kf.ttt.repository.NumRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 아니 십의자리가 '일십' 요난리로 출력됨 흑흑

public class NumberConverter {
  @Autowired
  private NumRepository numRepository;

  static String[] units = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
  static String[] value1 = {"", "십", "백", "천"};  
  static String[] value2 = {"", "만", "억", "조", "경"};
  
  public static String pickNum(String sentence) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(sentence);

    StringBuilder numOnly = new StringBuilder();

    while (matcher.find()) {
        numOnly.append(matcher.group());
    }

    return numOnly.toString();
  }
  
  public static List<Integer> splitNumber(int number, int n) {
    List<Integer> res = new ArrayList<>();
    int div = (int) Math.pow(10, n);

    while (number > 0) {
      int remainder = number % div;
      number = number / div;
      res.add(remainder);
    }
    return res;
  }

  public static String convertLt10000(int number, boolean delimiter) {
    String res = "";
    for (int place = 0; place < 4; place++) {
      int digit = number % 10;
      number = number / 10;
      if (digit == 0) continue;
      String num = (delimiter && digit == 1 && place != 0) ? "" : units[digit];
      res = num + value1[place] + res;
    }
    return res;
  }  
 
  // (10000)/(만)
  public static String numberToWordKo(int number, boolean delimiter) {
    if (number == 0) return "영";
    List<String> wordList = new ArrayList<>();
    int place = 0;  // 현재 자리 수
    while (number > 0) {
      int digits = number % 10000;
      number = number / 10000;
      String word = convertLt10000(digits, delimiter);
      if (!word.isEmpty()) {
          if (place > 0) {
              word += value2[place];
          }
          if (digits == 1 && place == 1) {
              wordList.add(value2[1]); // "만"을 추가
          } else {
              wordList.add(word);
          }
      }
      place++;
    }
    Collections.reverse(wordList);  // 리스트를 역순으로 정렬
    return String.join(delimiter ? "" : "", wordList);
  }

  // (10000)/(일만)
  public static String numberToWordKo2(int number, boolean delimiter) {
    if (number == 0) return "영";
    List<String> wordList = new ArrayList<>();
    int place = 0;  // 현재 자리 수
    while (number > 0) {
      int digits = number % 10000;
      number = number / 10000;
      String word = convertLt10000(digits, delimiter);
      if (!word.isEmpty()) {
        if (place > 0) {
            word += value2[place];
        }
        wordList.add(word);
      }
      place++;
    }
    Collections.reverse(wordList);  // 리스트를 역순으로 정렬
    return String.join(delimiter ? "" : "", wordList);
  } 

  public String convertAndSave(int number, boolean delimiter) {
    String result = numberToWordKo2(number, delimiter);
    Num num = new Num();
    num.setResult(result);
    // num.setLogtime(time);
    numRepository.numToKor();
    return result;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String sentence = scanner.nextLine();
    String numOnly = pickNum(sentence);
    String korean = "";

    if (!numOnly.isEmpty()) {
      int number = Integer.parseInt(numOnly);
      korean = numberToWordKo2(number, false);
      // System.out.println("(" + number + ")/(" + korean + ")");///////
    }
    String result = sentence.replaceAll(numOnly, "(" + numOnly + ")/(" + korean + ")");
    System.out.println(result);

  scanner.close();

    // if(!numOnly.isEmpty()){
    //   int number = Integer.parseInt(numOnly);
    //   String korean = numberToWordKo2(number, false);
    //   System.out.println("(" + number + ")/(" + korean + ")");
    // } else {
    //   System.out.println(sentence);
    // }
    // scanner.close();

    // int number = scanner.nextInt();
    
    // if (String.valueOf(number).charAt(0) == '1') {
    //     System.out.println("(" + number + ")/(" + numberToWordKo(number, true) + ")");
    // }
    
    // System.out.println("(" + number + ")/(" + numberToWordKo2(number, false) + ")");
    
    // scanner.close();
  }

}
