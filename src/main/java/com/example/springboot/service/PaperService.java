package com.example.springboot.service;

import com.example.basicLayout.Paper;
import com.example.jdbc.IPaperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IPaperDao paperDao=ac.getBean("paperDao",IPaperDao.class);

    public void postPaper(Paper paper){
        paperDao.updatePaper(paper);
    }
    public Paper previewPaper(int paperId){
        return paperDao.getpaperbyid(paperId);
    }
    public List<Paper> getAllPaper(){
        return paperDao.getAllpaper();
    }



}
