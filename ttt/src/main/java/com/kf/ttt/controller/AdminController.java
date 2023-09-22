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

	// 관리자 회원 목록 조회
	// 관리자 아이디 admin 제외하고 조회
	@PostMapping
	public List<User> admimSelectUser() {
		System.out.println(userService.admimSelectUser());
		return userService.admimSelectUser();
	}

	// 관리자 회원 추가
	@PostMapping("/add")
	public void addUser(String user_id, String passwd, String user_name) {

		// user_id 중복확인
		int check = userService.adminIdCheck(user_id);

		if (check == 0) {
			int result = userService.adminAddUser(user_id, passwd, user_name);
			System.out.println(result);
		} else {
			System.out.println("존재하는 아이디입니다.");
		}
		
//		admin 이나 manage 포함된 유사관리자아이디 추가 막기
//		if (check == 0) {
//			int result = userService.adminAddUser(user_id, passwd, user_name);
//			System.out.println(result);
//		} else if (user_id.contains("admin") == true || user_id.contains("manage") == true) {
//			System.out.println("사용할 수 없는 아이디입니다.");
//		} else {
//			System.out.println("존재하는 아이디입니다.");
//		}

	}
	
	//관리자 flag(로그인 여부) Y/N 수정하는 코드
	
	//관리자 회원 삭제하는 코드 
	@PostMapping("/delete")
	public void adminDeleteUser(String user_id) {
		
		int result = userService.adminDeleteUser(user_id);
		System.out.println(result);
		
	}
	
}
