package com.kf.ttt.num_kor;


//한국어 수사 셈낱씨(기수사)
public class NumberConverter2 {
  private static final String[] number_names = {
    "영", "하나", "둘", "셋", "넷", "다섯", "여섯", "일곱", "여덟", "아홉"
  };
  private static final String[] ten_names = {
    "", "열", "스물", "서른", "마흔", "쉰", "예순", "일흔", "여든", "아흔"
  };


  public static String convertToKorean(int number) {
    if (number >= 0 && number <= 99) {
      int ten = number / 10;
      int one = number % 10;

      String tenName = ten_names[ten];
      String oneName = number_names[one];

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

}
