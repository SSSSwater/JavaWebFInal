package com.example.springboot.controller;

import ai.djl.util.Pair;
import com.example.basicLayout.Account;
import com.example.jdbc.IntroOp;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;

@Slf4j
@Controller
public class IntroController {

    IntroOp intro = new IntroOp();

    @ResponseBody
    @RequestMapping(value = "/intro")
    public JSONObject introGetId(HttpSession session, HttpServletRequest request){
        ArrayList<Pair<String,String>> foodsId = intro.getIntrosByType(0);
        ArrayList<Pair<String,String>> scenesId = intro.getIntrosByType(1);
        ArrayList<Pair<String,String>> culturesId = intro.getIntrosByType(2);
        JSONObject json = new JSONObject();
        json.accumulate("foods",foodsId);
        json.accumulate("scenes",scenesId);
        json.accumulate("cultures",culturesId);
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/intro/getDetail")
    public Object introGetDetail(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        return intro.getIntroById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/intro/mod")
    public Boolean introModify(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        String img = request.getParameter("img");
        String history = request.getParameter("history");
        return intro.modifyIntro(id,name,detail,img,history);
    }
    @ResponseBody
    @RequestMapping(value = "/intro/create")
    public boolean introCreate(HttpSession session, HttpServletRequest request){
        String fromId = request.getParameter("fromId");
        String name = request.getParameter("name");
        String detail = request.getParameter("detail");
        String img = request.getParameter("img");
        String history = request.getParameter("history");
        String type = request.getParameter("type");
        return intro.createIntro(name,detail,img,history,type,fromId);

    }
    @ResponseBody
    @RequestMapping(value = "/intro/delete")
    public Boolean introDelete(HttpSession session, HttpServletRequest request){
        String id = request.getParameter("id");
        return intro.deleteIntro(id);
    }
    @ResponseBody
    @RequestMapping(value = "/intro/upImg")
    public String upImg(HttpSession session, HttpServletRequest request, MultipartFile file){

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
        String path="/img/intro/"+time+"."+pType;

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
    @RequestMapping("/intro.html")
    public String toIntro(){
        return "intro";
    }








}
