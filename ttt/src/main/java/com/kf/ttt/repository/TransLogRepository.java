package com.kf.ttt.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kf.ttt.entity.TransLog;

@Mapper
public interface TransLogRepository {
	public int addTransResultToLog(String user_id, String trans_result);
	
	public List<TransLog> transLogHistory(String user_id);
	
	public List<TransLog> searchTransLog(String user_id, String trans_result);
}
