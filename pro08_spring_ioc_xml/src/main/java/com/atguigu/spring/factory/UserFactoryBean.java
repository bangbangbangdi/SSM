package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.Student;
import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        //return new User();
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        //return User.class;
        return Student.class;
    }
}
