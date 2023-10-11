package com.kf.ttt.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.Board;

@Mapper
public interface BoardRepository {

	public List<Board> noticeBoardList();
	
	public Optional<Board> noticeBoardDetail(int board_id); 
	
	public int noticeBoardDelete(int board_id);
	
	public int noticeBoardInsert(String user_id, String title, String contents);
	
	public int noticeBoardUpdate(String title, String contents, int board_id);
}
