package com.example.springboot.service;

import com.example.basicLayout.Exam;
import com.example.jdbc.IExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IExamDao examDao=ac.getBean("examDao",IExamDao.class);

    public void postExam(Exam exam){
        examDao.updateExam(exam);
    }

}
