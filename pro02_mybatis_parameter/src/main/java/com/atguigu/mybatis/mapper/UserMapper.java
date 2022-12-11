package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/*
 * MyBatis获取参数值的两种方式：#{}和${}
 * #{}的本质是占位符赋值,${}的本质是字符串拼接
 * 1.若mapper接口方法的参数为单个字面量类型
 *  此时可以通过#{}和${}以任意的内容获取参数值,一定要注意${}的单引号问题
 * 2.若mapper接口方法的参数为多个字面量类型
 *   此时MyBatis会将参数放在map集合中,以两种方式存储数据
 *      a>以arg0,arg1...为键,以参数为值
 *      b>以param1,param2...为键,以参数为值
 *   因此,只需要通过#{}和${}访问map集合的键,就可以获取相应的值,一定要注意${}的单引号问题
 * 3.若mapper接口方法的参数为map集合类型的参数
 *   此时我们可以根据自己设定的key进行访问,其余跟2一致
 * 4.若mapper接口方法的参数为实体类型的参数(重要)
 *   只需要通过#{}和${}访问实体类中的属性名,就可以获取相应的属性值
 *      这里的属性名是通过实体类的get方法获取的,所以就算没有真正的成员变量也可以
 *      反之就算有相应的成员变量,但是缺少get方法的情况下,也无法获取相应的值
 * 5.可以在mapper接口方法的参数上设置@param注解(重要)
 *   a>以@param注解的value属性为键,以参数为值
 *   b>以param1,param2...为键,以参数为值
 * 只需要通过#{}和${}访问mpa集合的键，就可以获取相应的值
 * */
public interface UserMapper {

    /*
     * 根据用户名查询用户信息
     * */
    User getUserByUsername(String username);

    /*
     * 验证登录
     * */
    User checkLogin(String username, String password);

    /*
    * 验证登录(以Map集合作为参数)
    * */
    User checkLoginByMap(Map<String,Object> map);

    /*
    * 添加用户信息
    * */
    void insertUser(User user);

    /*
    * 验证登录(使用Param注解)
    * */
    User checkLoginByParam(@Param("username") String username, @Param("password")String password);

}
