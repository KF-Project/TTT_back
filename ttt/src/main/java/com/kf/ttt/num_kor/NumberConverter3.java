package com.kf.ttt.num_kor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//원투, 하나둘, 일이, 트웰브

public class NumberConverter3 {
    private static final String[] korNums = {"공", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    private static final String[] korNums_dec = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
    
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
                result.append(korNums_dec[index]);
//                System.out.println("result = " + result);
                
            } else if (digit == '.') {
            	result.append(" 점 ");
            	
            }
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    
    	String input = scanner.nextLine();
    	
    	//자연수 정규식 패턴
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
    	
        //소수 정규식 패턴 -> 기념일?
//    	Pattern p4dec = Pattern.compile("\\d+\\.\\d+");
    	Pattern p4dec = Pattern.compile("\\d+(\\.\\d+)");
        Matcher m4dec = p4dec.matcher(input);
        
        //전화번호 정규식 패턴
        Pattern p4phone = Pattern.compile("\\d+\\ \\d+\\ \\d+");
        Matcher m4phone = p4phone.matcher(input);
        
        Pattern p4phone_hy = Pattern.compile("\\d+\\-\\d+\\-\\d+");
        Matcher m4phone_hy = p4phone_hy.matcher(input);
        
        
        //소수 출력
        while (m4dec.find()) {
        	String number = m4dec.group();
        	
        	String left = number.split("\\.")[0];
            String right = number.split("\\.")[1]; 
            
            String leftRes = NumberConverter.numberToWordKo(Integer.parseInt(left), true);
            String rightRes = decimalPoint(right);
            
//        	String decimalConversion = decimalPoint(number);
        	
            System.out.println(input.replace(number, "(" + number + ")/(" + leftRes + " 점 " + rightRes + ")"));
            
        	
//        	if (number.contains(".")) {
//        		System.out.println(input.replace(number, "(" + number + ")/(" + decimalConversion + ")"));
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
            
            if (number.charAt(0) == '0') { //띄어쓰기 없는 전화번호 출력
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + phoneConversion + ")"));
            	
            	if (m4phone.find()) { //띄어쓰기 된 전화번호 출력
            		String num4phone = m4phone.group();
                	String phoneConversion_sp = convertToKorean(num4phone);
                	
                	System.out.println(input.replaceFirst(Pattern.quote(num4phone), "(" + num4phone + ")/(" + phoneConversion_sp + ")"));
                	
            	} else if (m4phone_hy.find()) { //하이픈 있는 전화번호 출력
            		String num4phone = m4phone_hy.group();
                	String phoneConversion_hy = convertToKorean(num4phone);
                	
                	System.out.println(input.replaceFirst(Pattern.quote(num4phone), "(" + num4phone + ")/(" + phoneConversion_hy + ")"));
            	}
                
            } else if (found) { //날짜 출력
            	System.out.println(input.replaceFirst(Pattern.quote(number + date), "(" + number + date + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + " " + date + ")"));
                
            } else if (Integer.parseInt(number) >= 10000 && number.charAt(0) == '1') { //10000 이상이고 1로 시작하는 수 앞에 '일' 출력
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
                
            } else if (Integer.parseInt(number) <= 99 && Integer.parseInt(number) > 0) { //'하나, 둘, 셋' 출력
            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter2.convertToKorean(Integer.parseInt(number)) + ")"));
                
            } else { //'일, 이, 삼' 출력
            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
            }
            
        }

        scanner.close();
    }

}

