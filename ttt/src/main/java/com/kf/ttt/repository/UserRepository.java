package com.kf.ttt.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.User;

@Mapper
public interface UserRepository {

	public List<User> test();
}
