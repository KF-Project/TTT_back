package com.kf.ttt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// 공지사항 게시판 전체 목록 조회
	@GetMapping
	public List<Board> noticeBoardList() {
		System.out.println(boardService.noticeBoardList());
		return boardService.noticeBoardList();
	}

	// 공지사항 상세보기
	@GetMapping("/detail/{board_id}")
	public ResponseEntity<Board> noticeBoardDetail(@PathVariable int board_id) {

		// 한 개의 데이터를 조회하는데, 값이 존재할 수도 있고 존재하지 않을 수도 있는 상황을 처리
		Optional<Board> boardOptional = boardService.noticeBoardDetail(board_id);

		if (boardOptional.isPresent()) {
			// 값이 존재하는 경우 boardOptional에서 Board 객체 추출
			Board board = boardOptional.get();

			// http 응답코드 200 ok, board 객체가 json 형태로 클라이언트에 반환
			return ResponseEntity.ok(board);
			
		} else {

			// http 응답코드 404 반환
			// build()를 사용하지 않는다면, 응답이 완성되지않은 상태로 남아있음. 즉 클라이언트에게 응답이 전송되지않음
			return ResponseEntity.notFound().build();
			
		}
	}

	// 공지사항 새글 등록
	@PostMapping("/new")
	public void noticeBoardInsert(String user_id, String title, String contents) {
		//세션 아이디가 admin일때 새글 등록 가능하도록 수정. 
		int result = boardService.noticeBoardInsert(user_id, title, contents);
		
		if(result == 1) {
			System.out.println("새글 등록 성공");
		}else {
			System.out.println("새글 등록 실패, 다시시도");
		}
	}
	
	// 공지사항 수정
	// put? patch..? 아니면 그냥 GET?..
	// DTO 설정? 
	@PutMapping("/update")
	public void noticeBoardUpdate(String title, String contents, int board_id) {
		//세션 아이디가 admin일 때 게시글 수정이 가능하도록 수정. 
		int result = boardService.noticeBoardUpdate(title, contents, board_id);
		
		if(result == 1) {
			System.out.println("공지사항 수정 완료");
		}else {
			System.out.println("공지사항 수정 실패, 다시시도 ");
		}
	}
	
	// 공지사항 삭제
	// 다중 삭제가 될지는 모르겠음. 
	@DeleteMapping("/delete")
	public void noticeBoardDelete(int board_id) {
		//세션 아이디가 admin 일 때 삭제 기능 되도록 수정
		int result = boardService.noticeBoardDelete(board_id);
		
		if(result == 1) {
			System.out.println("삭제 성공");
		}else {			
			System.out.println("삭제 실패");
		}
	}
	
	// 첨부파일
}
