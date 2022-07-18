package com.example.springboot.controller;

import com.example.basicLayout.Paper;
import com.example.basicLayout.Question;
import com.example.springboot.service.PaperService;
import com.example.springboot.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        log.info(questionService.getQuestion(id,subject,type).toString());
        return questionService.getQuestion(id,subject,type);
    }

    @ResponseBody
    @PostMapping("/teacher/post_paper")
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
        Paper paper=paperService.previewPaper(Integer.parseInt(request.getParameter("paperid")));
        String[] titleNum=paper.getTitlenum().split("/");
        String[] examMark=paper.getExammark().split("/");

        List<Question> questions=new ArrayList<>();

        for(int i=0;i<titleNum.length;i++){
            Question question=questionService.getQuestionById(Integer.parseInt(titleNum[i].substring(2)));

            question.setMark(Double.parseDouble(examMark[i].substring(2,examMark[i].length()-1)));
            questions.add(question);
        }


        paper.setQuestions(questions);
        return paper;

    }

    @GetMapping("/teacher/paper_preview.html")
    public String paperPreview(HttpServletRequest request){
        return "/teacher/paper_preview";
    }

}
