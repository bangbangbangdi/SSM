package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController controller = ioc.getBean(UserController.class);
        //UserService service = ioc.getBean(UserService.class);
        //UserDao userDao = ioc.getBean(UserDao.class);
        //System.out.println("controller = " + controller);
        //System.out.println("service = " + service);
        //System.out.println("userDao = " + userDao);
        controller.saveUser();
    }

}