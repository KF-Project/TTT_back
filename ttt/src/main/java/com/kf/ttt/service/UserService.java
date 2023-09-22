package com.kf.ttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.entity.User;
import com.kf.ttt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> test() {
		return userRepository.test();
	}

	public int id_check(String user_id, String passwd) {
		return userRepository.id_check(user_id, passwd);
	}
	
	public List<User> admimSelectUser(){
		return userRepository.admimSelectUser();
	}
	
	public int adminAddUser(String user_id, String passwd, String user_name) {
		return userRepository.adminAddUser(user_id, passwd, user_name);
	}
	
	public int adminIdCheck(String user_id) {
		return userRepository.adminIdCheck(user_id);
	}
	
	public int adminDeleteUser(String user_id) {
		return userRepository.adminDeleteUser(user_id);
	}
	
	public int adminUpdateFlag(String flag, String user_id) {
		return userRepository.adminUpdateFlag(flag, user_id);
	}

}
