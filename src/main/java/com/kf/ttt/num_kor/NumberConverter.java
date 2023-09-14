package com.kf.ttt.num_kor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// �ƴ� �����ڸ��� '�Ͻ�' �䳭���� ��µ� ����

public class NumberConverter {
  static String[] units = {"", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��"};
  static String[] value1 = {"", "��", "��", "õ"};  
  static String[] value2 = {"", "��", "��", "��", "��"};
  

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
 
  // (10000)/(��)
  public static String numberToWordKo(int number, boolean delimiter) {
    if (number == 0) return "��";
    List<String> wordList = new ArrayList<>();
    int place = 0;  // ���� �ڸ� ��
    while (number > 0) {
      int digits = number % 10000;
      number = number / 10000;
      String word = convertLt10000(digits, delimiter);
      if (!word.isEmpty()) {
          if (place > 0) {
              word += value2[place];
          }
          if (digits == 1 && place == 1) {
              wordList.add(value2[1]); // "��"�� �߰�
          } else {
              wordList.add(word);
          }
      }
      place++;
    }
    Collections.reverse(wordList);  // ����Ʈ�� �������� ����
    return String.join(delimiter ? "" : "", wordList);
  }

  // (10000)/(�ϸ�)
  public static String numberToWordKo2(int number, boolean delimiter) {
    if (number == 0) return "��";
    List<String> wordList = new ArrayList<>();
    int place = 0;  // ���� �ڸ� ��
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
    Collections.reverse(wordList);  // ����Ʈ�� �������� ����
    return String.join(delimiter ? "" : "", wordList);
  } 


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    
    if (String.valueOf(number).charAt(0) == '1') {
        System.out.println("(" + number + ")/(" + numberToWordKo(number, true) + ")");
    }
    
    System.out.println("(" + number + ")/(" + numberToWordKo2(number, false) + ")");
    
    scanner.close();
  }

}