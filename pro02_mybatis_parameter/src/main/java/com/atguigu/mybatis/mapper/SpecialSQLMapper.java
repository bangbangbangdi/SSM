package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /*
    * 通过用户名模糊查询用户信息
    *   有三种实现方式
    *   <!--select * from t_user where username like '%${mo}%'-->
        <!--select * from t_user where username like concat('%',#{mo},'%')-->
        select * from t_user where username like "%"#{mo}"#"
    */
    List<User> getUserByLike(@Param("mo") String mo);

    /*
    * 批量删除
    *   <!--以下这种方式会报错原因在于 #{} 会在赋值之后默认加上'' 即我们最终的sql语句是 ... in ('2,3')-->
        <!--解决方案：使用${} 字符串拼接-->
        <!--delete from t_user where id in (#{ids})-->
        <!--delete from t_user where id in (${ids})-->
    * */
    void deleteMoreUser(@Param("ids") String ids);

   /*
   * 动态设置表名，查询用户信息
   *    跟上面类似用#{}会因为自动添加''而报错
   * */
    List<User> getUserList(@Param("tableName") String tableName);


    /*
    * 添加用户信息并获取自增的主键
    *   useGenerateKeys:表示当前添加功能使用自增主键
        keyProperty:将添加的数据的自增主键为实体类型的指定参数赋值
    * 原理：调用了JDBC的相应方法，MyBatis是基于JDBC的框架
    * */
    void insertUser(User user);

}
