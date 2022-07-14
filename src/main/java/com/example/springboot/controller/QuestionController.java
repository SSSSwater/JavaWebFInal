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
public class QuestionController {

    @RequestMapping("/teacher/question_import_solo.html")
    public String importSolo(){
        return "/teacher/question_import_solo";
    }

    @RequestMapping("/teacher/question_import_multi.html")
    public String importMulti(){
        return "/teacher/question_import_multi";
    }

}
