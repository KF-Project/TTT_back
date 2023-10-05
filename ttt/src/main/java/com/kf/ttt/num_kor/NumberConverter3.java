package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//원투, 하나둘, 일이, 트웰브


public class NumberConverter3 {
    private static final String[] korNums = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    
    //전화번호
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
    
    //소수
    public static String decimalPoint(String decimal) {
    	StringBuilder result = new StringBuilder();

        for (char digit : decimal.toCharArray()) {
            if (Character.isDigit(digit)) {
                int index = Character.getNumericValue(digit);
                result.append(korNums[index]);
            } else if (digit == '.') {
                result.append(" 점 ");
            }
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    
    	String input = scanner.nextLine();
    	
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
    	
    	Pattern p4dec = Pattern.compile("\\d+\\.\\d+");
        Matcher m4dec = p4dec.matcher(input);
        
        //소수 출력
        while (m4dec.find()) {
        	String number = m4dec.group();
        	String decimalConversion = decimalPoint(number);
        	
//        	if (number.contains(".")) {
        		System.out.println(input.replace(number, "(" + number + ")/(" + decimalConversion + ")"));
//        	}
        	
        }
        	
        //소수 외 나머지 출력
        if (matcher.find()) {
        	
        	String number = matcher.group();
        	String phoneConversion = convertToKorean(number);
        	
        	//시간 구분
        	final String[] time = {"년", "월", "일", "시" };
            boolean found = false;
            String date = "";
            
            for (String keyword : time) {
            	if (input.contains(keyword)) {
            		found = true;
            		date = keyword;
            		break;
            	}
            	
            }
            
        	
            if (number.charAt(0) == '0') {
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + phoneConversion + ")"));
                
            } else if (found) {
            	System.out.println(input.replaceFirst(Pattern.quote(number + date), "(" + number + date + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + " " + date + ")"));
                
            } else if (Integer.parseInt(number) >= 10000 && number.charAt(0) == '1') {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
                
            } else if (Integer.parseInt(number) <= 99 && Integer.parseInt(number) > 0) {
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter2.convertToKorean(Integer.parseInt(number)) + ")"));
                
            } else {
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
            }
            
        }
        

        scanner.close();
    }

}

