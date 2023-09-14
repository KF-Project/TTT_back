package com.kf.ttt.controller;

public class TransController {
	public static void main(String args[]) {
		System.out.println("aaabbb");
	}
}

//
//import re
//
//#숫자+단위
//def changeUnit(text):
//    nstring = ""
//    
//    nlist = list(text.upper())
//    nd = {'k':'킬로','m':'미터'
//          
//          }
//
//
//#영어를 한글로
//def changeText(text):
//    
//    #nstring을 문자열로 초기화
//    nstring = ""
//    
//    # 입력 문자열을 대문자로 변환 후 리스트로 변환
//    nlist = list(text.upper())  
//    nd = {
//        'A': '에이', 'B': '비', 'C': '씨', 'D': '디', 'E': '이', 'F': '에프',
//        'G': '지', 'H': '에이치', 'I': '아이', 'J': '제이', 'K': '케이', 'L': '엘',
//        'M': '엠', 'N': '엔', 'O': '오', 'P': '피', 'Q': '큐', 'R': '알',
//        'S': '에스', 'T': '티', 'U': '유', 'V': '브이', 'W': '더블유', 'X': '엑스',
//        'Y': '와이', 'Z': '제트'
//    }
//    
//    #입력 문자열의 각 문자를 확인하여 nd 딕셔너리에 해당하는 대체 문자열을 만들어서 nstring에 추가
//    for i in nlist:
//        if i in nd:
//            nstring += nd[i]
//        else:
//            nstring += i
//
//    return nstring
//
//#사용자에게 입력을 받고 변환 결과 출력
//text = input('입력하세요: ')
//
//#입력받은 문자열이 정규식(한글/영어/숫자)에 매치되는지 검사
//compile_text = re.fullmatch(("^[a-zA-Z가-힣0-9]+$"),text)
//
//#match 객체 발생
//print(compile_text)
//
//if compile_text != None:
//     result = changeText(text)
//     print("("+text+")/("+result+")") #전사 규칙 형태
//else:
//    print("2byte 특수기호, 한자, 일본어 등은 오류로 간주합니다. 다시 입력하세요 ")
