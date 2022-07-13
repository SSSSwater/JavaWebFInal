package com.example.springboot.controller;

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
    @ResponseBody
    @RequestMapping(value = "/login")
    public Object doLogin(User user, HttpSession session,HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        user=userService.login(account,password);
        log.info(user.getAccount()+" "+user.getPassword()+" "+user.getRole());
        if(user.getRole()!=0) {
            // 登录成功，将用户信息保存到session对象中
            session.setAttribute("loginUser",user);
            log.info("登录成功");
            //防止重复提交使用重定向
//            return "redirect:/index";
            return user;
        }else{
            log.error("登录失败");
//            return "index";
            return null;
        }

    }

    @RequestMapping("/index.html")
    public String toIndex(){
        return "index";
    }




}
