package com.example.springboot.controller;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import com.example.springboot.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping("/teacher/exam_public")
    public String toPublic() {
        return "/teacher/exam_public.html";
    }

    @ResponseBody
    @RequestMapping("/teacher/exam_public.html")
    public String doPublic(HttpServletRequest request) {
        Teacher teacher= (Teacher) request.getSession().getAttribute("loginUser");









        return "/teacher/exam_public";
    }


    @RequestMapping(value = "/teacher/exam_public_sub")
    public Object doPublicSub(HttpServletRequest request) {

        Exam exam = new Exam();
        exam.setName(request.getParameter("name"));
        exam.setPaperId(request.getIntHeader("paperid"));
        exam.setExamClass(request.getParameter("examclass"));
        exam.setStartTime(request.getParameter("starttime"));
        exam.setEndTime(request.getParameter("endtime"));
        exam.setFinish(0);

        examService.postExam(exam);
        log.info(exam.toString());

        return "/teacher/exam_public_sub.html";
    }

    @RequestMapping(value = "/teacher/exam_public_sub.html")
    public String toPublicSub() {

        return "/teacher/exam_public_sub";
    }



    @ResponseBody
    @RequestMapping("/student/my_exam.html")
    public Object doMyExam(HttpServletRequest request){
        Student student= (Student) request.getSession().getAttribute("loginUser");
        log.info(student.toString());

        return examService.getStuExam(student.getId());
    }

    @RequestMapping("/student/my_exam")
    public String toMyExam(){
        return "/student/my_exam.html";
    }



}
