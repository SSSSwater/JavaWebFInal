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
    public String doImportMulti(HttpServletRequest request) {
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录(统默认的临时文件路径)
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");//这个不能改，改了连收到文件夹里的文件也会乱码=_=

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;


        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;//文件储存相对目录

                        // 保存文件到硬盘
                        log.info(filePath);
                        Getquestion.getQuestion(filePath);

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/teacher/question_import_multi.html";
    }


}
