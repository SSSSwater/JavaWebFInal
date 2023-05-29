package com.example.springboot.controller;

import com.example.basicLayout.Account;
import com.example.jdbc.AccountOp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Slf4j
@Controller
public class BioController {

    AccountOp bio = new AccountOp();

    @ResponseBody
    @RequestMapping(value = "/bio")
    public Object bioGet(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        Account account = bio.getAccountById(id);
        return account;
    }

    @ResponseBody
    @RequestMapping(value = "/bio/mod")
    public Boolean bioModify(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String detail = request.getParameter("detail");
        return  bio.modifyAccount(id,name,password,avatar,detail,email,phone);
    }

    @ResponseBody
    @RequestMapping(value = "/bio/delete")
    public Boolean bioDelete(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        return bio.deleteBio(id);
    }

    @ResponseBody
    @RequestMapping(value = "/bio/upAvt")
    public String upAvatar(HttpSession session, HttpServletRequest request, MultipartFile file){

        //判断文件类型
        String pType=file.getContentType();
        pType=pType.substring(pType.indexOf("/")+1);

        if("jpeg".equals(pType)){
            pType="jpg";
        }
        log.info(pType);
        long time=System.currentTimeMillis();
        //这里我采用绝对路径
        String property = System.getProperty("user.dir");
        String path="/img/avatar/"+time+"."+pType;

        log.info(property);
        File newFile = new File(property+path);
        log.info(newFile.getPath());
        try{
            newFile.createNewFile();
            file.transferTo(newFile);
            //文件路径保存到数据库中从而读取
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("上传成功");
        return path;
    }
    @RequestMapping("/bio.html")
    public String toBio(){
        return "bio";
    }








}
