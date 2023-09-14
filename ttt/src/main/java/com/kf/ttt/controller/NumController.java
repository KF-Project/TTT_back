package com.kf.ttt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kf.ttt.service.NumService;

@Controller
public class NumController {
    @Autowired
    private NumService numService;
}
