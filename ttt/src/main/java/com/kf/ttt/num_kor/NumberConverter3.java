package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//원투, 하나둘, 일이, 투웰브
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
        	
            String number = matcher.group();
            String koreanConversion = convertToKorean(input);

//            System.out.println(input.replace(matcher.group(), "(number = " + number + ")"));
            if (Integer.parseInt(number) >= 10000 && number.charAt(0) == '1') {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            } else if (Integer.parseInt(number) <= 99 && Integer.parseInt(number) > 0) {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter2.convertToKorean(Integer.parseInt(number)) + ")"));
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            } else if (number.charAt(0) == '0' || number.contains(" ") || number.contains("-")) {
            	System.out.println(input.replace(matcher.group(), "(number = " + number + ")"));
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + koreanConversion + ")"));
            }
            
        }
        

        scanner.close();
    }
}

