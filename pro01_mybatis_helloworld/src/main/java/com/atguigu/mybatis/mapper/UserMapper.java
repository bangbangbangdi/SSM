package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {


    int insertUser();

   /*
   * 修改用户信息
   * */
    void updateUser();

    void deleteUser();

    /*
    * 根据id查询User对象
    * */
    User getUserById();

    List<User> getAllUser();
}
