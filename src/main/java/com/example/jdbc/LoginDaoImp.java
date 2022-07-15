package com.example.jdbc;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class LoginDaoImp extends JdbcDaoSupport implements IloginDao {

    @Override
    public Student findStudentByAp(String account, String password) {
        List<Student> students = getJdbcTemplate().query("select * from student where account = ? and password = ?",new BeanPropertyRowMapper<Student>(Student.class),account,password);
        return students.isEmpty()?null:students.get(0);
    }

    @Override
    public Teacher findTeacherByAp(String account, String password) {
        List<Teacher> teachers = getJdbcTemplate().query("select * from teacher where account = ? and password = ?",new BeanPropertyRowMapper<Teacher>(Teacher.class),account,password);
        return teachers.isEmpty()?null:teachers.get(0);
    }

    @Override
    public Manager findManagerByAp(String account, String password) {
        List<Manager> managers = getJdbcTemplate().query("select * from student where manager = ? and password = ?",new BeanPropertyRowMapper<Manager>(Manager.class),account,password);
        return managers.isEmpty()?null:managers.get(0);
    }

    @Override
    public String findTeaClass(int worknum) {
        String sql = "select classnum from teacher where worknnum = "+worknum;
        String teaclass = getJdbcTemplate().queryForObject(sql,String.class);
        return teaclass;
    }

    @Override
    public void updateStudent(Student students) {
        String sql="insert into student (id,name,classnum,school,account,password)value('"+students.getId()+"','"+students.getName()+"','"+students.getClassnum()+"','"+students.getSchool()+"','"
                +students.getAccount()+"','"+students.getPassword()+"')";
        getJdbcTemplate().execute(sql);
    }

    @Override
    public void updateTeacher(Teacher teachers) {
        String sql="insert into teacher (worknum,name,school,grade,subject,classnum,account,password)value('"+teachers.getWorknum()+"','"+teachers.getName()+"','"+teachers.getSchool()+"','"
                +teachers.getGrade()+"','"+teachers.getSubject()+"','"+teachers.getClassnum()+"','"+teachers.getAccount()+"','"+teachers.getPassword()+"')";
        getJdbcTemplate().execute(sql);
    }

    @Override
    public void updateManager(Manager managers) {
        String sql="insert into manager (account,password)value('"+managers.getAccount()+"','"+managers.getPassword()+"')";
        getJdbcTemplate().execute(sql);
    }

}
