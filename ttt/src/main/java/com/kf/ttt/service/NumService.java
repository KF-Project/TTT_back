package com.kf.ttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kf.ttt.num_kor.NumberConverter;

@Service
public class NumService {
   @Autowired
    private NumberConverter numberConverter;

    public String convertAndSave(int number, boolean delimiter) {
        return numberConverter.convertAndSave(number, delimiter);
    }
}