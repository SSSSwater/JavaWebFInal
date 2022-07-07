package com.example.springboot.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@Slf4j
@Controller
public class LoginController {

    /*
    UserService userService;
    @PostMapping("/manage")
    public String manage(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object o=session.getAttribute("user");
        if(o==null){
            log.info("登录失败");
            return "redirect:/login";
        }
        User loginUser=(User) o;//强转为User

    }
*/

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

    @RequestMapping(value = "/login")
    public String getLogin(HttpServletRequest request, HttpServletResponse response, Model model) {

        String account = request.getParameter("student_account");
        String password = request.getParameter("student_password");

        try {
            System.out.println(account);
            System.out.println(password);
            Class.forName(JDBC_DRIVER);
//            if (searchForStu(account, password)) {
//                response.sendRedirect("index.html");
//                System.out.println("1");
//            } else if (searchForTea(account, password)) {
//                response.sendRedirect("index.html");
//                System.out.println("2");
//            } else if (searchForCom(account, password)) {
//                response.sendRedirect("index.html");
//                System.out.println("3");
//            }
            if (account=="student") {
                response.sendRedirect("make_paper.html");
                System.out.println("1");
            } else if (account=="teacher") {
                response.sendRedirect("make_paper.html");
                System.out.println("2");
            } else if (account=="admin") {
                response.sendRedirect("make_paper.html");
                System.out.println("3");
            }


        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return "index";

    }


    //账号登录验证
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/user?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "admin";

    public static boolean searchForStu(String account, String password) {
        String sql = "select * from student_table where account = '" + account + "' and password = '" + password + "'";
        Boolean flag = false;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("success!");
            if (rs.next()) {
                System.out.println("Success");
                flag = true;
                String number = rs.getString("number");
                String name = rs.getString("name");
                String classnumber = rs.getString("classnumber");
                String sex = rs.getString("sex");
                String schoolname = rs.getString("schoolname");
                //System.out.printf("number:%s name:%s className:%s sex:%s schoolName：%s\n", number, name, classnumber, sex, schoolname);
                //System.out.println("你好！");
            } else {
                System.out.println("Fail");
            }

            conn.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean searchForTea(String account, String password) {
        String sql = "select * from teacher_table where account = '" + account + "' and password = '" + password + "'";
        Boolean flag = false;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("success!");
            if (rs.next()) {
                //System.out.println("Success");
                flag = true;
                String teacherworknumber = rs.getString("teacherworknumber");
                String name = rs.getString("name");
                String schoolname = rs.getString("schoolname");
                //System.out.printf("number:%s name:%s className:%s sex:%s schoolName：%s\n", number, name, classnumber, sex, schoolname);
                //System.out.println("你好！");
            } else {
                System.out.println("Fail");
            }

            conn.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean searchForCom(String account, String password) {
        String sql = "select * from student_table where account = '" + account + "' and password = '" + password + "'";
        Boolean flag = false;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("success!");
            if (rs.next()) {
                //System.out.println("Success");
                flag = true;
                //String teacherworknumber = rs.getString("teacherworknumber");
                //String name = rs.getString("name");
                //String schoolname = rs.getString("schoolname");
                //System.out.printf("number:%s name:%s className:%s sex:%s schoolName：%s\n", number, name, classnumber, sex, schoolname);
                //System.out.println("你好！");
            } else {
                System.out.println("Fail");
            }

            conn.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }


}
