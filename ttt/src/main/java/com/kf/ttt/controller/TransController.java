package com.kf.ttt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.service.TransService;

//http 요청 처리하는 역할
//클라이언트 요청 받아서 비즈니스 로직 호출한 후, 클라이언트에 다시 반환하는 로직

@RestController
@RequestMapping("/trans")
public class TransController {

	@Autowired
	TransService transService;

	@GetMapping("/{text}")
	public Map<String, String> engToKorean(@PathVariable("text") String text) {
		String transLation = transService.engToKorean(text);

		Map<String, String> response = new HashMap<>();
		response.put("text", text);
		response.put("transLation", transLation);
		return response;

	}
}
