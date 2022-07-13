package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {

    @RequestMapping("/teacher/exam_public")
    public String postExam(){


        return "/teacher/exam_public.html";
    }
    @RequestMapping("/teacher/exam_public.html")
    public String doExam(){
        return "/teacher/exam_public";
    }

}
