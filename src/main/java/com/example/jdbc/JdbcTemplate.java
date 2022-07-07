package com.example.jdbc;

import com.example.basicLayout.Question;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JdbcTemplate {
    public static void main(String[] args) {
        //获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
//        IloginDao loginDao = ac.getBean("loginDao", IloginDao.class);
//        System.out.println(loginDao.findStudentbyap("1234","zyj12345"));
        ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
        IQuestionDao questionDao =ac.getBean("questionDao",IQuestionDao.class);
        List<Question> questions = questionDao.getallQuestion();
//        Question q = new Question("Physics","judge","时间的流逝有快有慢","A.对","B.错",null,null,"B","flase",null);
//        questionDao.updateQuestion(q);
//        Question q2 = new Question("Physics","judge","衣服会产热","A.对","B.错",null,null,"B","flase",null);
//        questionDao.updateQuestion(q2);
//        List<Question> questions = questionDao.findQuestionbySubject("Math");
        for(Question q:questions ){
            System.out.println(q);
        }

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


//自定义封装
//class QuestionRowMapper implements RowMapper<Question> {
//    //把结果集中的数据封装到Text中，然后由spring把每个Text加到集合中
//
//    @Override
//    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Question questions = new Question();
//        questions.setId(rs.getInt("id"));
//        questions.setSubject(rs.getString("subject"));
//        questions.setType(rs.getString("type"));
//        questions.setTitle(rs.getString("title"));
//        questions.setChoiceA(rs.getString("choiceA"));
//        questions.setChoiceB(rs.getString("choiceB"));
//        questions.setChoiceC(rs.getString("choiceC"));
//        questions.setChoiceD(rs.getString("choiceD"));
//        questions.setAnswer(rs.getString("answer"));
//        questions.setAnalysisEnabled(rs.getString("analysisenabled"));
//        questions.setAnalysis(rs.getString("analysis"));
//        return questions;
//
//    }
//}