package com.example.jdbc;

import com.example.basicLayout.Exam;
import com.example.basicLayout.Paper;
import com.example.basicLayout.Result;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class ExamDaoImp extends JdbcDaoSupport implements IExamDao {

    @Override
    public void updateExam(Exam exam) {
        String sql="insert into exam (name,paperid,examclass,startime,endtime,finish)value('"+exam.getName()+"','"+exam.getPaperId()+"','"+exam.getExamClass()+"','"+exam.getStartTime()+"','"+exam.getEndTime()+"','"+exam.isFinish()+"')";
        getJdbcTemplate().execute(sql);
    }

    @Override
    public boolean finish(int examid) {
        String sql = "select finish from exam where examid = "+examid;
        Boolean fin = getJdbcTemplate().queryForObject(sql,boolean.class);
        return fin;
    }

    @Override
    public List<Exam> findExamByStnum(int stnum) {
        List<Result> result = getJdbcTemplate().query("select * from results where stnum = ?",new BeanPropertyRowMapper<Result>(Result.class),stnum);
        List<Exam> exams= new ArrayList<>();
        for(Result r:result){
            int n = r.getExamid();
            exams.add(findExambyExamID(n));
        }
        return exams;
    }

    @Override
    public Exam findExambyExamID(int examid) {
        List<Exam> exam = getJdbcTemplate().query("select * from exam where examid = ?",new BeanPropertyRowMapper<Exam>(Exam.class),examid);
        return exam.isEmpty()?null:exam.get(0);
    }


}
