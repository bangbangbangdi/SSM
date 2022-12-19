package com.atguigu.spring.controller;

import com.atguigu.spring.service.UserService;

public class UserController {

    /*
    * 这里就可以体现spring IOC容器解耦的优势
    * 如果以后有新的UserService实现类需要应用到程序中，只需要在相关的配置文件中修改property的ref属性即可
    * */
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }

}