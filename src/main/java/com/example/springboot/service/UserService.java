package com.example.springboot.service;

import com.example.basicLayout.User;
import com.example.jdbc.IQuestionDao;
import com.example.jdbc.IloginDao;
import com.example.jdbc.LoginDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    ApplicationContext ac =new ClassPathXmlApplicationContext("Bean.xml");
    IloginDao loginDao =ac.getBean("loginDao", IloginDao.class);
    public User login(String account,String password){
        User user = new User(account,password);
        if (loginDao.findStudentByAp(account, password)) {
            user.setRole(1);
        }else if(loginDao.findStudentByAp(account,password)){
            user.setRole(2);
        }else{
            user.setRole(3);
        }
        return user;
    }

}
