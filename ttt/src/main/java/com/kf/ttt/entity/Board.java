package com.kf.ttt.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Board {
	private int board_id;
	private String user_id;
	private String title;
	private String contents;
	private Date regDate;

}
