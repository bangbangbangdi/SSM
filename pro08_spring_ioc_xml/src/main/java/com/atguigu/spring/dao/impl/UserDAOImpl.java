package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
