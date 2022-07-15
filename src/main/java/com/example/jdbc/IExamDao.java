package com.example.jdbc;

import com.example.basicLayout.Exam;

public interface IExamDao {
    public void updateExam(Exam exam);

    public boolean finish(int examid);
}
