package com.example.jdbc;

public interface IloginDao {
    String findStudentbyap(String account,String password);

    String findTeacherbyap(String account,String password);

    String findmanagerbyap(String account,String password);
}

