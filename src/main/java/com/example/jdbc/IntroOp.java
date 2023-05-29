package com.example.jdbc;

import ai.djl.util.Pair;
import com.example.basicLayout.Account;
import com.example.basicLayout.IntroObject;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class IntroOp extends JdbcDaoSupport{

    Connection con;
    Statement stat;
    ResultSet rs=null;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fin","root","123456");
            stat=con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<Pair<String,String>> getIntrosByType(int type){
        try {
            rs=stat.executeQuery("select * from introduction where `type`='"+type+"'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ArrayList<Pair<String,String>> id_name = new ArrayList<>();
        while(true) {
            try {
                if (!rs.next()) break;
                id_name.add(new Pair<String,String>(String.valueOf(rs.getInt(1)),rs.getString(2)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return id_name;
    }
    public IntroObject getIntroById(String id){
        try {
            rs=stat.executeQuery("select * from introduction where `id`='"+id+"'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        while(true) {
            try {
                if (!rs.next()) break;
                return new IntroObject(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public boolean createIntro(String name,String detail
            ,String img,String history,String type,String fromId){
        try {
            stat.execute("insert into introduction(" +
                    "`name`, `detail`, img, `history`, `type`, `fromId`)" +
                    " values ('"+name+"','"+detail
                    +"','"+img+"','"+history+"','"+type+"','"+fromId+"')");
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean deleteIntro(String id){
        try {
            stat.execute("delete from introduction where `id` = "+id);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean modifyIntro(String id,String name,String detail
            ,String img,String history){
        try {
            String sql="update introduction set `name` = '"+name+"', `detail` = '"+detail+
                    "',  `img` = '"+img+"',  `history` = '"+history+
                    "' where `id` =  '"+id+"'";
            stat.execute(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args){
    }
}
