package com.example.springboot.service;

import com.example.basicLayout.Manager;
import com.example.basicLayout.Student;
import com.example.basicLayout.Teacher;
import com.example.basicLayout.User;
import com.example.jdbc.IloginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
    IloginDao loginDao = ac.getBean("loginDao", IloginDao.class);

    public User login(String account, String password) {
        User user;
        if (loginDao.findStudentByAp(account, password) != null) {
            user=loginDao.findStudentByAp(account, password);
        } else if (loginDao.findStudentByAp(account, password) != null) {
            user=loginDao.findTeacherByAp(account, password);
        } else  {
            user=loginDao.findManagerByAp(account, password);
        }
        return user;
    }

}
