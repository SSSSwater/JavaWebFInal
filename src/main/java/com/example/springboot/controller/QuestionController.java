package com.example.springboot.controller;

import com.example.basicLayout.Question;
import com.example.exelgetquestion.Getquestion;
import com.example.springboot.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Controller
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("/teacher/question_import_solo.html")
    public String importSolo() {
        return "/teacher/question_import_solo";
    }

    @RequestMapping("/teacher/question_import_solo")
    public String doImportSolo(HttpServletRequest request) {
        Question question = new Question();
        question.setType(request.getParameter("question_type"));
        question.setSubject("question_subject");
        question.setAnalysisEnabled(request.getParameter("analysis_enabled"));
        question.setTitle(request.getParameter("question_title"));

        String[] choice;


        switch (question.getType()) {
            case "single" -> {
                question.setAnswer(request.getParameter("single_answer"));
                choice = request.getParameterValues("single_choice");
                question.setChoiceA(choice[0]);
                question.setChoiceB(choice[1]);
                question.setChoiceC(choice[2]);
                question.setChoiceD(choice[3]);
            }
            case "multiple" -> {
                question.setAnswer(request.getParameter("multiple_answer"));
                choice = request.getParameterValues("multiple_choice");
                question.setChoiceA(choice[0]);
                question.setChoiceA(choice[1]);
                question.setChoiceA(choice[2]);
                question.setChoiceA(choice[3]);
            }
            case "judge" -> question.setAnswer(request.getParameter("judge_answer"));
            case "cloze" -> question.setAnswer(request.getParameter("cloze_answer"));
            case "short" -> question.setAnswer(request.getParameter("s_answer"));
        }
        question.setAnalysis(request.getParameter("analysis"));

        questionService.postQuestion(question);
        log.info(question.toString());

        return "/teacher/question_import_solo.html";
    }



    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    @RequestMapping("/teacher/question_import_multi.html")
    public String toImportMulti() {
        return "/teacher/question_import_multi";
    }

    @RequestMapping("/teacher/question_import_multi")
    public String doImportMulti() {



        return "/teacher/question_import_multi.html";
    }


}
