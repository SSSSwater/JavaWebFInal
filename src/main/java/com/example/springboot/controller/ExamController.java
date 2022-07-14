package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExamController {

    @RequestMapping("/teacher/exam_public")
    public String doPublic(){









        return "/teacher/exam_public.html";
    }
    @RequestMapping("/teacher/exam_public.html")
    public String toPublic(){
        return "/teacher/exam_public";
    }


    @RequestMapping("/teacher/exam_public_sub")
    public String doPublicSub(){








        return "/teacher/exam_public_sub.html";
    }
    @RequestMapping("/teacher/exam_public_sub.html")
    public String toPublicSub(){
        return "/teacher/exam_public_sub";
    }

    @RequestMapping("/teacher/paper_preview")
    public String doPreview(){









        return "/teacher/paper_preview.html";
    }

    @RequestMapping("/teacher/paper_preview.html")
    public String toPreview(){
        return "/teacher/paper_preview";
    }
}
