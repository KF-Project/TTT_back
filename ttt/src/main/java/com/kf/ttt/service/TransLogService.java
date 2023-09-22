package com.kf.ttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.repository.TransLogRepository;

@Service
public class TransLogService {
	
	@Autowired
	TransLogRepository transLogRepository;
	
	public int transResultLog(String user_id, String trans_result) {
		return transLogRepository.transResultLog(user_id, trans_result); 
	}
}
