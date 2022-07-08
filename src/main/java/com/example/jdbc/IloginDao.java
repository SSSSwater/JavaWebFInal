package com.example.jdbc;

public interface IloginDao {
    boolean findStudentByAp(String account,String password);

    boolean findTeacherByAp(String account,String password);

    boolean findManagerByAp(String account,String password);
}

