package com.kf.ttt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kf.ttt.service.NumService;
import com.kf.ttt.entity.Num;

@RestController
@RequestMapping("/num")
public class NumController {
    @Autowired
    private NumService numService;

    @GetMapping
    public List<Num> numToKor() {
        return numService.numToKor();
    }
    
}
