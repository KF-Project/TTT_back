package com.kf.ttt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.entity.Board;
import com.kf.ttt.service.BoardService;


//관리자는 공지사항 게시판 crud 가능
//일반 사용자는 공지사항 게시판 r 가능
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@PostMapping
	public List<Board> noticeBoardList(){
		System.out.println(boardService.noticeBoardList());
		return boardService.noticeBoardList();
	}
	
}
