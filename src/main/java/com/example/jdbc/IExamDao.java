package com.example.jdbc;

import com.example.basicLayout.Exam;

import java.util.List;
import java.util.Set;

public interface IExamDao {
    public void updateExam(Exam exam);

    public boolean finish(int examid);

    List<Exam> findExamByStnum(int stnum);

    public Exam findExambyExamID(int examid);

    public List<Exam> findExamByTeaclass(String[] teaclass);

    public List<Exam> findExamByExamclass(String examclass);

    public List<Exam> findAllExam();
}
