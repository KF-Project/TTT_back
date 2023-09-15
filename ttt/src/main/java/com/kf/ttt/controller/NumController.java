package com.kf.ttt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kf.ttt.service.NumService;

@Controller
@RequestMapping("/num")
public class NumController {
    @Autowired
    private NumService numService;
}
