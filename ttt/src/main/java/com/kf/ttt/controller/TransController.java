package com.kf.ttt.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.service.TransLogService;
import com.kf.ttt.service.TransService;

//http 요청 처리하는 역할
//클라이언트 요청 받아서 비즈니스 로직 호출한 후, 클라이언트에 다시 반환하는 로직

@RestController
@RequestMapping("/trans")
public class TransController {

	@Autowired
	TransService transService;

	@Autowired
	TransLogService transLogService;
	
	@GetMapping("/{text}")
	public Map<String, String> engToKorean(@PathVariable("text") String text) throws Exception{

		String trans_result = transService.engToKorean(text);
		
		System.out.println("전사 결과: "+trans_result);
		
		//로그인한 user 세션 id 가져오기
//		String user_id = (String) session.getAttribute("session_user_id");
//		System.out.println(user_id);
		
		
		
		if(trans_result != null && trans_result != "") {
			//세션 id로 수정해야함.
			transLogService.addTransResultToLog("kf03", trans_result);
			System.out.println(transLogService.addTransResultToLog("kf03", trans_result));
		}
		
		Map<String, String> response = new HashMap<>();
		response.put("text", text);
		response.put("trans_result", trans_result);
		return response;

	}
}
