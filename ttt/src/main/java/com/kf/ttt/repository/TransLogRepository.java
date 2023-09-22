package com.kf.ttt.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransLogRepository {
	public int transResultLog(String user_id, String trans_result);
}
