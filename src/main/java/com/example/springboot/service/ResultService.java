package com.example.springboot.service;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Teacher;
import com.example.jdbc.IExamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IExamDao examDao=ac.getBean("examDao",IExamDao.class);
    public List<Exam> getTeaExam(Teacher teacher){
        String[] classNum=teacher.getClassnum().split("/");
        return examDao.findExamByTeaclass(classNum);
    }
    public List<Exam> getAllExam(){
        return examDao.findAllExam();
    }


}
