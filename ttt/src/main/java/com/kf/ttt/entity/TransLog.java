package com.kf.ttt.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransLog {
	private int log_id;
	private String user_id;
	private String trans_result;
	private Date trans_time;	
}
