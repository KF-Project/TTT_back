package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberConverter3 {
    private static final String[] korNums = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

    public static String convertToKorean(String phoneNumber) {
        StringBuilder result = new StringBuilder();

        for (char digit : phoneNumber.toCharArray()) {
            if (Character.isDigit(digit)) {
                int index = Character.getNumericValue(digit);
                result.append(korNums[index]);
                result.append(" ");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    
    	String input = scanner.nextLine();
        
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
        	
            int number = Integer.parseInt(matcher.group());
            String koreanConversion = convertToKorean(input);

            
            if (number >= 10000 && String.valueOf(number).charAt(0) == '1') {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo(number, true) + ")"));
            } else if (number <= 99 && number > 0) {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter2.convertToKorean(number) + ")"));
            } 
//            else if (String.valueOf(number).charAt(0) == '0') {
//            	System.out.println(input.replace(matcher.group(), "(" + input + ")/(" + koreanConversion + ")"));
//            }
//            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")"));
//            System.out.println("(" + input + ")/(" + koreanConversion + ")");
            System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(number, true) + ")"));
            System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + koreanConversion + ")"));
        }
        
        
//        String phone = scanner.nextLine();
//        String koreanConversion = convertToKorean(phone);
//        
//        System.out.println("(" + phone + ")/(" + koreanConversion + ")");
    	
        
        
        
        scanner.close();
    }
}

