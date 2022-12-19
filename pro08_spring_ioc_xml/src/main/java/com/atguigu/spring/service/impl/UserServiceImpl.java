package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.UserDAO;
import com.atguigu.spring.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.saveUser();
    }
}