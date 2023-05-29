package com.example.springboot.controller;

import com.example.jdbc.AccountOp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class RegController {

    AccountOp reg = new AccountOp();

    @ResponseBody
    @RequestMapping(value = "/register")
    public Object Register(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String avatar = request.getParameter("avatar");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String detail = request.getParameter("detail");
        return reg.createAccount(id,name,password,avatar,detail,email,phone);
    }
    @RequestMapping("/register.html")
    public String toRegister(){
        return "register";
    }







}
