package com.kf.ttt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logout", method= {RequestMethod.POST})
public class LogoutController {

	//로그아웃 구현
	//세션 remove 
	
}
