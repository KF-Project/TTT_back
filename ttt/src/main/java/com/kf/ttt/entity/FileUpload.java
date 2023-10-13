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
public class FileUpload {
	private int upload_id;
	private int board_id;
	private String origin_file_name;
	private String fileName;
	private String filePath;
	private Date regDate;
}
