package com.example.jdbc;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Paper;
import com.example.basicLayout.Question;
import com.example.basicLayout.Student;
import com.example.springboot.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplate {
    public static void main(String[] args) {
//        Paper paper1 = new Paper(1,"单元一测试卷","Math","3-5-2-6-10","20-20-20-20-20");
//        Paper paper2 = new Paper(2,"单元二测试卷","Math","3-5-2-6-10","20-20-20-20-20");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
//        IExamDao iexamDao = ac.getBean("examDao",IExamDao.class);
//        boolean yn = iexamDao.finish(1);
        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
        IExamDao iexamDao = ac.getBean("examDao",IExamDao.class);
        String[] cla = new String[2];
        cla[0]="G1-1";
        cla[1]="G1-2";
        List<Exam> exams = iexamDao.findExamByTeaclass(cla);
//        List<Paper> papers = ipaperDao.getPaperbysubject("Math");
//        Paper paper = ipaperDao.getpaperbyname("单元一测试卷");
//        ipaperDao.updatePaper(paper1);
//        ipaperDao.updatePaper(paper2);
//        List<Paper> papers = ipaperDao.getAllpaper();
        for(Exam e: exams){
            System.out.println(e);
        }





        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
//        IloginDao loginDao = ac.getBean("loginDao", IloginDao.class);
//        System.out.println(loginDao.findStudentByAp("1234","zyj12345"));
//        ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
//        IQuestionDao questionDao =ac.getBean("questionDao",IQuestionDao.class);
//        List<Question> questions = questionDao.getallQuestion();
//        Question q = new Question("Physics","judge","时间的流逝有快有慢","A.对","B.错",null,null,"B","flase",null);
//        questionDao.updateQuestion(q);
//        Question q2 = new Question("Physics","judge","衣服会产热","A.对","B.错",null,null,"B","flase",null);
//        questionDao.updateQuestion(q2);
//        List<Question> questions = questionDao.findQuestionbySubject("Math");
//        for(Question q:questions ){
//            System.out.println(q);
//        }

//        Question question = questionDao.findQuestionbyID(1);
//        System.out.println(question);
//        //获取对象
//        org.springframework.jdbc.core.JdbcTemplate jt = ac.getBean("JdbcTemplate", org.springframework.jdbc.core.JdbcTemplate.class);
//        //执行操作
////        List<Question> texts=jt.query("select * from question where id = ?",new QuestionRowMapper(),1);
//        List<Question> texts=jt.query("select * from question where id = ?",new BeanPropertyRowMapper<Question>(Question.class),1);
//        System.out.println(texts.isEmpty()?"没有内容":texts.get(0));
    }
}

//
//    }
//}