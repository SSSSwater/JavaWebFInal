package com.example.springboot.service;

import com.example.basicLayout.Question;
import com.example.jdbc.IQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IQuestionDao questionDao =ac.getBean("questionDao", IQuestionDao.class);

    //用于组卷时筛选符合条件的题目
    public List<Question> getQuestion(int id, String subject, String type){
        List<Question> questions=new ArrayList<>();
        if(id!=0){
            questions.add(questionDao.findQuestionbyID(id));
        }else{
            if(subject!=null&&type==null){
                questions=questionDao.findQuestionbySubject(subject);
            }else if(subject==null&&type!=null){
                questions=questionDao.findQuestionbytype(type);
            }else{
                questions=questionDao.findQuestionbyst(subject,type);
            }
        }

        return questions;
    }

    //用于单题导入数据库
    public void postQuestion(Question question){
        questionDao.updateQuestion(question);
    }



}
