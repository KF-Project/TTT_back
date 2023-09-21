package com.kf.ttt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService userService;
	
	
	@PostMapping
	public Map<String, String> login(String user_id,String passwd, 
			HttpSession session)throws Exception{
		
		Map<String, String> map = new HashMap<String , String>();
		
		System.out.println("파라미터 로그인 아이디:"+  user_id);
		System.out.println("파라미터 로그인 비밀번호:"+  passwd);
		
		
		int check = userService.id_check(user_id, passwd);
		
		System.out.println("--------------------------"+check+"--------------------------");
		
		if(check == 1 ) {
			session.setAttribute("session_user_id", user_id);
			session.setAttribute("login_ok", "yes");
			
			map.put("status", "true");
			map.put("message", "login_success");
			//map.put("url", "/user");
			
		}else {
			map.put("status", "false");
			map.put("message", "login_fail");
		}
		return map;
	}
	

}
