package com.example.jdbc;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class loginDaoImp extends JdbcDaoSupport implements IloginDao {

    @Override
    public String findStudentbyap(String account, String password) {
        List<Student> students = getJdbcTemplate().query("select * from student where account = ? and password = ?",new BeanPropertyRowMapper<Student>(Student.class),account,password);
        return students.isEmpty()?null:"student";
    }

    @Override
    public String findTeacherbyap(String account, String password) {
        List<Teacher> teachers = getJdbcTemplate().query("select * from teacher where account = ? and password = ?",new BeanPropertyRowMapper<Teacher>(Teacher.class),account,password);
        return teachers.isEmpty()?null:"teacher";
    }

    @Override
    public String findmanagerbyap(String account, String password) {
        List<Manager> managers = getJdbcTemplate().query("select * from student where manager = ? and password = ?",new BeanPropertyRowMapper<Manager>(Manager.class),account,password);
        return managers.isEmpty()?null:"manager";
    }

}
