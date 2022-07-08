package com.example.jdbc;
//账户持久层实现

import com.example.basicLayout.Question;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class QuestionDaoImp extends JdbcDaoSupport implements IQuestionDao{

    @Override
    public Question findQuestionbyID(Integer id) {
        List<Question> questions= getJdbcTemplate().query("select * from question where id = ?",new BeanPropertyRowMapper<Question>(Question.class),id);
        return questions.isEmpty()?null:questions.get(0);
    }

    @Override
    public List<Question> findQuestionbytype(String type) {
        List<Question> questions= getJdbcTemplate().query("select * from question where type = ?",new BeanPropertyRowMapper<Question>(Question.class),type);
        if(questions.isEmpty()){
            return null;
        }
        return questions;
    }

    @Override
    public List<Question> findQuestionbySubject(String subject) {
        List<Question> questions= getJdbcTemplate().query("select * from question where subject = ?",new BeanPropertyRowMapper<Question>(Question.class),subject);
        if(questions.isEmpty()){
            return null;
        }
        return questions;
    }

    @Override
    public void updateQuestion(Question questions) {
//        String subject = questions.getSubject();
//        String type = questions.getType();
//        String title = questions.getTitle();
//        String choiceA = questions.getChoiceA();
//        String choiceB = questions.getChoiceB();
//        String choiceC = questions.getChoiceC();
//        String choiceD = questions.getChoiceD();
//        String answer = questions.getAnswer();
//        String analysisEnabled = questions.getAnalysisEnabled();
//        String analysis = questions.getAnalysis();
        String sql="insert into question (subject,type,title,choiceA,choiceB,choiceC,choiceD,answer,analysisEnabled,analysis)value('"+questions.getSubject()+"','"+questions.getType()+"','"+questions.getTitle()+"','"+questions.getChoiceA()+"','"
                +questions.getChoiceB()+"','"+questions.getChoiceC()+"','"+
                questions.getChoiceD()+"','"+questions.getAnswer()+"','"+
                questions.getAnalysisEnabled()+"','"+questions.getAnalysis()+"')";
//        System.out.println(sql);
        getJdbcTemplate().execute(sql);
    }

    @Override
    public List<Question> getallQuestion() {
        List<Question> questions = getJdbcTemplate().query("select * from question",new BeanPropertyRowMapper<Question>(Question.class));
        return questions;
    }

    @Override
    public List<Question> findQuestionbyst(String subject, String type) {
        List<Question> questions = getJdbcTemplate().query("select * from question where subject = ? and type = ?",new BeanPropertyRowMapper<Question>(Question.class),subject,type);
        return questions.isEmpty()?null:questions;
    }
}
