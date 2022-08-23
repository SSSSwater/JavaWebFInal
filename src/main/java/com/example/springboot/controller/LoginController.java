package com.example.springboot.controller;

import com.example.basicLayout.Student;
import com.example.basicLayout.User;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public Object login(HttpSession session, HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userService.login(account, password);
        log.info(user.getAccount()+" "+ user.getPassword()+" "+ user.getRole());

        if(user.getRole()!=0) {
            session.setAttribute("loginUser", user);
            log.info(request.getSession().getAttribute("loginUser").toString());
            log.info("登录成功");
            if(user.getRole()==1){
                return "redirect:/student/my_exam.html";
            }else{
                return "redirect:/index.html";
            }
        }else{
            log.error("登录失败");
            return "login.html";
        }
    }
    @RequestMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/index.html")
    public String toIndex(){
        return "index";
    }







}
