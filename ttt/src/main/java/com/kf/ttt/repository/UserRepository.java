package com.kf.ttt.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.User;

@Mapper
public interface UserRepository {

	public List<User> test();
	
	public int id_check(String user_id, String passwd);
	
	public User login(String user_id, String passwd);
	
}
