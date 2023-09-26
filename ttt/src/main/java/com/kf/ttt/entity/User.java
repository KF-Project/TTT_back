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
public class User {
	private String user_id;
	private String passwd;
	private String flag;
	private String user_name;
	private Date regDate;
}
