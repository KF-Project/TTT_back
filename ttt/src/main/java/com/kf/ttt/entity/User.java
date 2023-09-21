package com.kf.ttt.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String user_id;
	private String passwd;
	private String flag;
	private String user_name;
	private Date regDate;
}
