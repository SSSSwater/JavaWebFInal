package com.example.springboot.controller;

import com.example.basicLayout.Teacher;
import com.example.springboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    @RequestMapping("/teacher/result_management.html")
    public String toResult(){
        return "/teacher/result_management";
    }


    @ResponseBody
    @RequestMapping("/teacher/result_management")
    public Object doResult(HttpServletRequest request, HttpServletResponse response){

        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
//        Teacher teacher=(Teacher) request.getSession().getAttribute("loginUser");
//        return resultService.getTeaExam(teacher);
//        return "/teacher/result_management.html";
        return resultService.getAllExam();
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
