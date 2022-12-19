package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Student;
import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        //User user = ioc.getBean(User.class);
        //System.out.println("user = " + user);
        Student student = ioc.getBean(Student.class);
        System.out.println("student = " + student);
    }

}
