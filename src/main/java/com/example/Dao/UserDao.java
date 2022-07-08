package com.example.Dao;

import com.example.basicLayout.User;
import org.springframework.stereotype.Repository;

public interface UserDao {
    // 根据用户名和密码获得用户信息
    User login(String account,String password);
}
