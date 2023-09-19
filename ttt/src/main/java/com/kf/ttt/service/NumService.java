package com.kf.ttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.entity.Num;
import com.kf.ttt.repository.NumRepository;

@Service
public class NumService {
   @Autowired
    private NumRepository numRepository;

    public List<Num> numToKor() {
        return numRepository.numToKor();
    }
}