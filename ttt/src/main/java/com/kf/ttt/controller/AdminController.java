package com.kf.ttt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.entity.User;
import com.kf.ttt.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	UserService userService;
	
	//관리자 회원 목록 조회
	@PostMapping
	public List<User> admimSelectUser(){
		System.out.println(userService.admimSelectUser());
		return userService.admimSelectUser();
	}
	
	//관리자 회원 추가
	//중복된 아이디 추가 안되도록 수정하기
	@PostMapping("/addUser")
	public void addUser(String user_id, String passwd, String user_name) {
		
		int check = userService.adminIdCheck(user_id);
		
		if (check == 0) {
			int result = userService.adminAddUser(user_id, passwd, user_name);
			System.out.println(result);	
		}else {
			System.out.println("존재하는 아이디입니다.");
		}
		
	}
}
