package com.kf.ttt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.entity.Board;
import com.kf.ttt.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public List<Board> noticeBoardList(){
		return boardRepository.noticeBoardList();
	}
	
	public Optional<Board> noticeBoardDetail(int board_id){
		return boardRepository.noticeBoardDetail(board_id);
	}
	
	public int noticeBoardDelete(int board_id) {
		return boardRepository.noticeBoardDelete(board_id);
	}
	
	public int noticeBoardInsert(String user_id, String title, String contents) {
		return boardRepository.noticeBoardInsert(user_id, title, contents);
	}
	
	public int noticeBoardUpdate(String title, String contents, int board_id) {
		return boardRepository.noticeBoardUpdate(title, contents, board_id);
	}
}
