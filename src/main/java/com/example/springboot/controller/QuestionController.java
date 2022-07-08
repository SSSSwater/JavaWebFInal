package com.example.springboot.controller;

import com.example.basicLayout.Question;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class QuestionController {

    @ResponseBody
    @RequestMapping(value = "/tiku",method = RequestMethod.GET)
    public Object getQuestion(HttpServletRequest request, Model model){
        HashMap<Integer,Question> questions=new HashMap<>();
        Question question=new Question();

        questions.put(1,new Question(1,"Chinese","single"));
        questions.put(2,new Question(2,"Chinese","multiple"));
        questions.put(3,new Question(3,"Math","single"));
        questions.put(4,new Question(4,"Math","judge"));
        questions.put(5,new Question(5,"Math","multiple"));

        int id=Integer.parseInt(request.getParameter("id"));
        String subject=request.getParameter("subject");
        String type=request.getParameter("type");




        HashMap<Integer,Question> ans= new HashMap<>();

        int i=0;
        for(Map.Entry<Integer,Question> entry:questions.entrySet()){
            question=entry.getValue();
            if(question.getId()==id||question.getType().equals(type)|| question.getSubject().equals(subject)){
                ans.put(i++,question);
            }
        }
        return question;
    }

}
