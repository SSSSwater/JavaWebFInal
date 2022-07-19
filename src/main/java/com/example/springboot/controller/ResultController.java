package com.example.springboot.controller;

import com.example.basicLayout.Teacher;
import com.example.springboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    @RequestMapping("/teacher/result_management")
    public String toResult(){
        return "/teacher/result_management.html";
    }


    @ResponseBody
    @RequestMapping("/teacher/result_management.html")
    public Object doResult(HttpServletRequest request){
        Teacher teacher=(Teacher) request.getSession().getAttribute("loginUser");
        return resultService.getTeaExam(teacher);
    }


    @RequestMapping("/teacher/result_management_sub")
    public String manageSub(){
        return "/teacher/result_management_sub.html";
    }
    @RequestMapping("/teacher/result_management_sub.html")
    public String doSub(){
        return "/teacher/result_management_sub";
    }
}
