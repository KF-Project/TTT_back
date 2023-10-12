package com.kf.ttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.entity.TransLog;
import com.kf.ttt.repository.TransLogRepository;

@Service
public class TransLogService {
	
	@Autowired
	TransLogRepository transLogRepository;
	
	public int addTransResultToLog(String user_id, String trans_result) {
		return transLogRepository.addTransResultToLog(user_id, trans_result); 
	}
	
	public List<TransLog> transLogHistory(String user_id){
		return transLogRepository.transLogHistory(user_id);
	}
	
	public List<TransLog> searchTransLog(String user_id, String trans_result){
		return transLogRepository.searchTransLog(user_id, trans_result);
	}
}
