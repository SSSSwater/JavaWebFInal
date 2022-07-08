package com.example.springboot.Controller;

import com.example.basicLayout.User;
import com.example.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.html")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o != null) {
            log.info("已经登录");
            return "redirect:/manage";
        }
        log.info("未登录");
        return "index.html";
    }

    @RequestMapping("/manage")
    public String manage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            log.info("登录失败");
            return "redirect:/login";
        }
        User loginUser = (User) o;//强转为User

        //根据role返回不同的地址
        return "index";
    }

/*
    @RequestMapping(value = "/login")
    public String doLogin(User user, Map<String,Object> map, HttpSession session,HttpServletRequest request){
        String account = request.getParameter("student_account");
        String password = request.getParameter("student_password");
        if(searchForStu(account,password)) {
            // 登录成功，将用户信息保存到session对象中
            session.setAttribute("loginUser",user);
            log.info("登录成功");
            //防止重复提交使用重定向
            return "redirect:/index";
        }else{
            map.put("message","用户名或密码错误");
            log.error("登录失败");
            return "login";
        }
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
*/




}
