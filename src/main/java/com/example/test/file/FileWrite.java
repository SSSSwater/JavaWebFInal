package com.example.test.file;

import java.sql.*;
import java.io.*;

public class FileWrite {
    //将读取的文件解析为题目并写入数据库

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/question?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "admin";

    /*public static void sql() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public static void execute(String tablename,String question,String answer) {
        String sql = "insert into "+ tablename + "(question,answer)value('"+question+"','"+answer+"')";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void execute(String tablename,String question,String answer,String A,String B,String C,String D) {
        String sql = "insert into "+ tablename + "(question,answer,choiceA,choiceB,choiceC,choiceD)value('"+question+"','"+answer+"','"+A+"','"+B+"','"+C+"','"+D+"')";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void execute(String tablename,String question,String answer,String chose1,String chose2) {
        String sql = "insert into "+ tablename + "(question,chose1,chose2,answer)value('"+question+"','"+chose1+"','"+chose2+"','"+answer+"')";
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void txtString(File file) {
        System.out.println("enter txtString method");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String result = "";
            String s = " ";
            String cla = " ";
            int flag = 1;
            String A =" ";
            String B =" ";
            String C =" ";
            String D =" ";
            String chose1 = " ";
            String chose2 = " ";
            String answer = "";
            while ((s = br.readLine()) != null)
            {
                if (s.equals("cloze"))
                {
                    cla = "cloze";
                    flag = 2;
                    continue;
                }
                if(s.equals("single")) {
                    cla = "single";
                    flag = 4;
                    continue;
                }
                if(s.equals("judge")){
                    cla = "judge";
                    flag = 10;
                    continue;
                }
                if(s.equals("multiple")){
                    cla = "multiple";
                    flag = 4;
                    continue;
                }
                if (flag == 2) {
                    result = result + s;
                    flag = 3;
                    continue;
                }
                if (flag == 3) {
                    answer = answer + s;
                    execute(cla, result, answer);
                    cla = " ";
                    result = " ";
                    answer = " ";
                    s = " ";
                    flag = 1;
                    continue;
                }
                if(flag == 4){
                    result = result + s;
                    flag = 5;
                    continue;
                }
                if(flag == 5){
                    A = A + s;
                    flag = 6;
                    continue;
                }
                if(flag == 6){
                    B = B + s;
                    flag = 7;
                    continue;
                }
                if(flag == 7){
                    C = C + s;
                    flag = 8;
                    continue;
                }
                if(flag == 8){
                    D = D + s;
                    flag = 9;
                    continue;
                }
                if(flag == 9){
                    answer = answer + s;
                    execute(cla,result,answer,A,B,C,D);

                    cla = " ";
                    result = " ";
                    answer = " ";
                    s = " ";
                    A = " ";
                    B = " ";
                    C = " ";
                    D = " ";
                    flag = 1;
                    continue;
                }
                if(flag == 10){
                    result = result + s;
                    flag = 11;
                    continue;
                }
                if(flag == 11){
                    chose1 = chose1 + s;
                    flag = 12;
                    continue;
                }
                if(flag == 12){
                    chose2 = chose2 + s;
                    flag = 13;
                    continue;
                }
                if(flag == 13){
                    answer = answer + s;
                    execute(cla,result,answer,chose1,chose2);
                    cla = " ";
                    result = " ";
                    answer = " ";
                    chose1 = " ";
                    chose2 = " ";
                    s = " ";
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
