package com.example.springboot.controller;

import com.example.springboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object doTeaResult(HttpServletResponse response){

        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return resultService.getAllExam();
    }


    @RequestMapping("/teacher/result_management_sub")
    public String manageSub(){
        // TODO 老师管理本班学生的考试结果






        return "/teacher/result_management_sub.html";
    }
    @RequestMapping("/teacher/result_management_sub.html")
    public String doSub(){
        return "/teacher/result_management_sub";
    }





    @RequestMapping("/student/my_result.html")
    public String toStuResult(){
        return "/student/my_exam";
    }

    @ResponseBody
    @RequestMapping("/student/my_result")
    public Object doStuResult(HttpServletResponse response){
        // 跨域支持
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // TODO 获取学生已经完成的考试
        //先用所有考试充数了(

        return resultService.getAllExam();
    }

}
