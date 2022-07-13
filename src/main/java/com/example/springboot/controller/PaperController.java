package com.example.springboot.controller;

import com.example.springboot.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class PaperController {
    @Autowired
    QuestionService questionService;
    @ResponseBody
    @GetMapping(value = "/teacher/make_paper")
    public Object makePaper(HttpServletRequest request){
        log.info("获取题目");
        int id=Integer.parseInt(request.getParameter("id"));
        String subject=request.getParameter("subject");
        String type=request.getParameter("type");
        log.info(id+subject+type);
        log.info(questionService.getQuestion(id,subject,type).toString());
        return questionService.getQuestion(id,subject,type);
    }

    @RequestMapping("/teacher/make_paper.html")
    public String doPaper(){
        return "/teacher/make_paper";
    }



}
