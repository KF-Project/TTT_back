package com.kf.ttt.num_kor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                
            } else if (digit == '.') {
            	result.append(" 점 ");
            	
            }
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    
    	String input = scanner.nextLine();
    	String result1 = input;
    	String result2 = input;
    	
    	//자연수 정규식 패턴
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
    	
        //소수 정규식 패턴
    	Pattern p4dec = Pattern.compile("\\d+\\.\\d+");
        Matcher m4dec = p4dec.matcher(input);
        
        //전화번호 정규식 패턴
        Pattern p4phone = Pattern.compile("\\d+\\ \\d+\\ \\d+");
        Matcher m4phone = p4phone.matcher(input);
        
        Pattern p4phone_hy = Pattern.compile("\\d+\\-\\d+\\-\\d+");
        Matcher m4phone_hy = p4phone_hy.matcher(input);
        
        //단위 정규식 패턴
        Pattern p4m = Pattern.compile("\\d+[a-z]+");
        Matcher m4m = p4m.matcher(input);
        
//        while (true) {
        //소수 출력
        while (m4dec.find()) {
        	String decimal = m4dec.group();
        	
        	String left = decimal.split("\\.")[0];
            String right = decimal.split("\\.")[1]; 
            
            String leftRes = NumberConverter.numberToWordKo(Integer.parseInt(left), true);
            String rightRes = decimalPoint(right);
            
            //기념일과 소수 구분
            List<String> specalDays = Arrays.asList("2.28", "3.1", "3.8", "3.15", "4.3", "4.19", "5.18", "6.10", "6.25", "8.15");
            
            if (specalDays.contains(decimal)) {
            	System.out.println(input.replace(decimal, "(" + decimal + ")/(" + leftRes + rightRes + ")"));
            } else 
            	System.out.println(input.replace(decimal, "(" + decimal + ")/(" + leftRes + " 점 " + rightRes + ")"));
//            break;
        }
        
        //단위 출력
        while (m4m.find()) {
        	String unit = m4m.group();
        	String numbers = unit.replaceAll("[^0-9]", "");
            String letters = unit.replaceAll("[^a-zA-Z]", "");
        	
        	HashMap<String, String> unitMap = new HashMap<>();
        	unitMap.put("mm", "밀리미터, 밀리"); //넓이
            unitMap.put("cm", "센티미터, 센티");
            unitMap.put("m", "미터");
            unitMap.put("km", "킬로미터, 킬로");
            unitMap.put("in", "인치");
            unitMap.put("mg", "밀리그램, 밀리"); //무게
            unitMap.put("g", "그램");
            unitMap.put("kg", "킬로그램, 킬로");
            unitMap.put("t", "톤");
            unitMap.put("cc", "시시"); //부피
            unitMap.put("ml", "밀리리터, 밀리");
            unitMap.put("L", "리터");
            unitMap.put("bit", "비트"); //데이터양
            unitMap.put("B", "바이트");
            unitMap.put("KB", "킬로바이트");
            unitMap.put("MB", "메가바이트, 메가");
            unitMap.put("GB", "기가바이트, 기가");
            unitMap.put("TB", "테라바이트, 테라");
            
            if (unitMap.containsKey(letters)) {
            	System.out.println(input.replace(unit, "(" + unit + ")/(" +  NumberConverter.numberToWordKo(Integer.parseInt(numbers), true) + " " + unitMap.get(letters) + ")"));
            } 
//            break;
        }
        	
        //소수 외 나머지 출력
        while (matcher.find()) {
        	
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
                	break;
                	
            	} else if (m4phone_hy.find()) { //하이픈 있는 전화번호 출력
            		String num4phone = m4phone_hy.group();
                	String phoneConversion_hy = convertToKorean(num4phone);
                	
                	System.out.println(input.replaceFirst(Pattern.quote(num4phone), "(" + num4phone + ")/(" + phoneConversion_hy + ")"));
                	break;
            	}
                
            } else if (found) { //날짜 출력
            	System.out.println(input.replaceFirst(Pattern.quote(number + date), "(" + number + date + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + " " + date + ")"));
            	//replaceFirst 대신 replace 써보삼
                
            } else if (Integer.parseInt(number) >= 10000 && number.charAt(0) == '1') { //10000 이상이고 1로 시작하는 수 앞에 '일' 출력
//            	System.out.println(input.replace(matcher.group(), "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")"));
//            	System.out.println(input.replaceFirst(Pattern.quote(number), "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")"));
            	
            	result1 = result1.replace(number, "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")");
            	result2 = result2.replace(number, "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")");
                
            } else if (Integer.parseInt(number) <= 99 && Integer.parseInt(number) > 0) { //'하나, 둘, 셋' 출력
            	result1 = result1.replace(number, "(" + number + ")/(" + NumberConverter.numberToWordKo2(Integer.parseInt(number), true) + ")");
            	result2 = result2.replace(number, "(" + number + ")/(" + NumberConverter2.convertToKorean(Integer.parseInt(number)) + ")");
                
            } else { //'일, 이, 삼' 출력
            	result1 = result1.replace(number, "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")");
            	result2 = result2.replace(number, "(" + number + ")/(" + NumberConverter.numberToWordKo(Integer.parseInt(number), true) + ")");
            }
            
        }
        
        System.out.println(result1);
        System.out.println(result2);
        
        scanner.close();
//    }
    }
}

