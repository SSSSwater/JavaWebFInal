package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultController {
    @RequestMapping("/teacher/result_management")
    public String manageResult(){
        return "/teacher/result_management.html";
    }
    @RequestMapping("/teacher/result_management.html")
    public String doResult(){
        return "/teacher/result_management";
    }

}
