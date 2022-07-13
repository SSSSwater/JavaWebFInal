package com.example.jdbc;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;

import java.util.List;

public interface IloginDao {
    Student findStudentByAp(String account, String password);

    Teacher findTeacherByAp(String account,String password);

    Manager findManagerByAp(String account,String password);

    void updateStudent(Student students);

    void updateTeacher(Teacher teachers);

    void updateManager(Manager managers);
}

