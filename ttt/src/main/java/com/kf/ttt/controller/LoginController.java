package com.kf.ttt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.entity.User;
import com.kf.ttt.service.TransLogService;
import com.kf.ttt.service.UserService;

@RestController
@RequestMapping(value = "/login", method= {RequestMethod.POST})
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	TransLogService transLogService;
	
	@Autowired
	User user;
	
	@PostMapping
	public Map<String, String> login(String user_id,String passwd, 
			HttpSession session)throws Exception{
		
		Map<String, String> map = new HashMap<String , String>();
		
		System.out.println("파라미터 로그인 아이디:"+  user_id);
		System.out.println("파라미터 로그인 비밀번호:"+  passwd);
		
		
		int check = userService.id_check(user_id, passwd);
		
		System.out.println("--------------------------"+check+"--------------------------");
		
		//로그인 성공하면 select해온 값을 user에 담아야하나 ?
		if(check == 1 ) {
			
			user = userService.login(user_id, passwd);
			System.out.println(user);
			System.out.println(user.getUser_id());
			
			System.out.println(transLogService.transLogHistory("kf02"));
			
			session.setAttribute("session_user_id", user.getUser_id());
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
