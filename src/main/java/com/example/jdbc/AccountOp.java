package com.example.jdbc;

import com.example.basicLayout.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.*;

public class AccountOp extends JdbcDaoSupport{

    Connection con;
    Statement stat;
    ResultSet rs=null;

    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fin","root","123456");
            stat=con.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Account verify(String userId,String userPassword){

        try {
            rs = stat.executeQuery("select * from accounts where `userId`='"+userId+"' and `userPassword`='"+userPassword+"'");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
//        List<Account> accounts = getJdbcTemplate().query("select * from accounts where userName = ? and userPassword = ?",new BeanPropertyRowMapper<Account>(Account.class),userName,userPassword);
        while(true){
            try {
                if (!rs.next()) break;
                System.out.println(userId);
                return getAccountById(userId);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        }
        return new Account();
    }

    public Account getAccountById(String id){
        try {
            rs=stat.executeQuery("select * from accounts where `userId`='"+id+"'");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        while(true) {
            try {
                if (!rs.next()) break;
                return new Account(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return null;
    }
    public boolean createAccount(String userId,String userName,String userPassword
            ,String userAvatar,String userDetail,String userEmail,String userPhone){
        try {
            stat.execute("insert into accounts(" +
                    "`userId`, `userName`, `userPassword`, userAvatar, `userDetail`, `userEmail`, `userPhone`)" +
                    " values ('"+userId+"','"+userName+"','"+userPassword
                    +"','"+userAvatar+"','"+userDetail+"','"+userEmail+"','"+userPhone+"')");
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    public boolean modifyAccount(String userId,String userName,String userPassword
            ,String userAvatar,String userDetail,String userEmail,String userPhone){
        try {
            String sql="update accounts set `userName` = '"+userName+"', `userPassword` = '"+userPassword+
                    "',  `userAvatar` = '"+userAvatar+"',  `userDetail` = '"+userDetail+
                    "',  `userEmail` = '"+userEmail+"',  `userPhone` = '"+userPhone+
                    "' where `userId` =  '"+userId+"'";
            stat.execute(sql);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
    public boolean deleteBio(String id){
        try {
            String sql="delete from accounts where `userId` = '"+id+"'";
            stat.execute(sql);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args){
    }
}
