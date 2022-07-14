package com.example.jdbc;

import com.example.basicLayout.Exam;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ExamDaoImp extends JdbcDaoSupport implements IExamDao {

    @Override
    public void updateExam(Exam exam) {
        String sql="insert into exam (name,paperid,examclass,starttime,endtime,finish)value('"+exam.getName()+"','"+exam.getPaperId()+"','"+exam.getExamClass()+"','"+exam.getStartTime()+"','"+exam.getEndTime()+"','"+exam.isFinish()+"')";
        getJdbcTemplate().execute(sql);
    }
}
