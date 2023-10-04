package com.kf.ttt.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.Board;

@Mapper
public interface BoardRepository {

	public List<Board> noticeBoardList();
}
