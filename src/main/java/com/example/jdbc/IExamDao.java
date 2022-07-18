package com.example.jdbc;

import com.example.basicLayout.Exam;

import java.util.List;

public interface IExamDao {
    public void updateExam(Exam exam);

    public boolean finish(int examid);

    List<Exam> findExamByAcc();
}
