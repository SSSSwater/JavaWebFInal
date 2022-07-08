package com.example.jdbc;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;

public interface IloginDao {
    boolean findStudentByAp(String account,String password);

    boolean findTeacherByAp(String account,String password);

    boolean findManagerByAp(String account,String password);

    void updateStudent(Student students);

    void updateTeacher(Teacher teachers);

    void updateManager(Manager managers);
}

