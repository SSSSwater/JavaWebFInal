package com.example.springboot.controller;

import com.example.basicLayout.Exam;
import com.example.springboot.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping("/teacher/exam_public")
    public String doPublic(HttpServletRequest request) {

        return "/teacher/exam_public.html";
    }

    @RequestMapping("/teacher/exam_public.html")
    public String toPublic() {
        return "/teacher/exam_public";
    }


    @RequestMapping(value = "/teacher/exam_public_sub")
    public Object doPublicSub(HttpServletRequest request) {

        Exam exam = new Exam();
        exam.setName(request.getParameter("name"));
        exam.setPaperId(request.getIntHeader("paperid"));
        exam.setExamClass(request.getParameter("examClass"));
        exam.setStartTime(request.getParameter("starttime"));
        exam.setEndTime(request.getParameter("endtime"));
        exam.setFinish(0);

        examService.postExam(exam);
        log.info(exam.toString());

        return "/teacher/exam_public_sub.html";
    }

    @RequestMapping(value = "/teacher/exam_public_sub.html")
    public String toPublicSub(HttpServletRequest request) {

        return "/teacher/exam_public_sub";
    }


    @RequestMapping("/teacher/paper_preview")
    public String doPreview() {


        return "/teacher/paper_preview.html";
    }

    @RequestMapping("/teacher/paper_preview.html")
    public String toPreview() {
        return "/teacher/paper_preview";
    }
}
