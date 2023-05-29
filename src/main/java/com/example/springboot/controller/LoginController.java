package com.example.springboot.controller;

import com.example.basicLayout.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.jdbc.AccountOp;
@Slf4j
@Controller
public class LoginController {

    AccountOp login = new AccountOp();

    @ResponseBody
    @RequestMapping(value = "/login")
    public Object login(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        log.info(id+" "+password);
        Account account = login.verify(id,password);
        session.setAttribute("logging", account.toString());
        log.info("登录成功");
        log.info(account.toString());
        return account;
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
