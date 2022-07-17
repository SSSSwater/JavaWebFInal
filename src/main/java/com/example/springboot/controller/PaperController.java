package com.example.springboot.controller;

import com.example.basicLayout.Paper;
import com.example.springboot.service.PaperService;
import com.example.springboot.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Controller
public class PaperController {
    @Autowired
    QuestionService questionService;
    @Autowired
    PaperService paperService;

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

    @ResponseBody
    @PatchMapping("/teacher/post_paper")
    public Object postPaper(HttpServletRequest request){
        Paper paper=new Paper();
        paper.setSubject(request.getParameter("subject"));
        paper.setTitlenum(Arrays.toString(request.getParameterValues("titlenum")));
        paper.setExammark(request.getParameter("exammark"));
        paper.setPapername(request.getParameter("papername"));

        log.info(paper.toString());
        paperService.postPaper(paper);


        return paper;
    }

    @RequestMapping("/teacher/make_paper.html")
    public String doPaper(){
        return "/teacher/make_paper";
    }

    @ResponseBody
    @RequestMapping("/teacher/paper_preview")
    public Object doPreview(HttpServletRequest request){

        return paperService.previewPaper(request.getIntHeader("paperid"));
    }

    @RequestMapping("/teacher/paper_preview.html")
    public String paperPreview(){

        return "/teacher/paper_preview";
    }

}
