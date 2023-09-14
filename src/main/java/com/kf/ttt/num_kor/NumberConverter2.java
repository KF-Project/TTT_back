package com.kf.ttt.num_kor;

import java.util.Scanner;

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
        return "삐빅 0 ~ 99 입력 plz";
    }
  }

  // public static void main(String[] args) {
  //   Scanner scanner = new Scanner(System.in);
  //   int number = scanner.nextInt();

  //   if (String.valueOf(number).charAt(0) == '1') {
  //       System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo(number, true) + ")");
  //   }

  //   System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo2(number, false) + ")");

  //   scanner.close();
  // }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    if (String.valueOf(number).charAt(0) == '1') {
        System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo(number, true) + ")");
    }

    System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo2(number, false) + ")");
    System.out.println("(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")");

    scanner.close();
  }
}
