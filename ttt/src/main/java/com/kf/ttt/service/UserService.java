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

}
