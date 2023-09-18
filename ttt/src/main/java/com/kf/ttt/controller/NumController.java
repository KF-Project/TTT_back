package com.kf.ttt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kf.ttt.num_kor.NumberConverter;
import com.kf.ttt.service.NumService;
import com.kf.ttt.repository.NumRepository;
import com.kf.ttt.entity.Num;

import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/convert")
public class NumController {
    @Autowired
    private NumService numService;
    @Autowired
    private NumberConverter numberConverter;
    @Autowired
    private NumRepository numRepository;

    @GetMapping("/form")
    public String showForm() {
        return "convert-form";
    }

    @PostMapping("/result")
    public String convertAndSave(@RequestParam("number") int number,
                                @RequestParam(value = "delimiter", defaultValue = "false") boolean delimiter,
                                Model model) {
        String result = numberConverter.convertAndSave(number, delimiter);

        Num num = new Num();
        num.setResult(result);
        // num.setKoreanNumber(result);
        numRepository.save(num);

        model.addAttribute("result", result);
        return "convert-result";
    }
    

}
