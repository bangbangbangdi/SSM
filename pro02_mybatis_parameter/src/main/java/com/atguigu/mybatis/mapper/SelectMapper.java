package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
* 若sql语句查询的结果为多条时，一定不能以实体类型作为方法的返回值
* 否则会抛出异常，TooManyResultsException
*
* 若查询的结果不存在实体类，则需要将查询结果存储到map集合中
*   key：字段名 value：存储的值
*   注意：如果此时查询结果中存在null值，则不会存储到map中
*
* 若查询到的数据有多条，并且要将每条数据转换为map集合中，此时有两种方案
*   a>将mapper接口的方法的返回值设置为范型是map的list集合
*   b>可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解，将查询的某个字段的字段值作为大的map键
* */
public interface SelectMapper {

    /*
    * 根据ID查询用户信息
    * */
    User getUserById(@Param("id") Integer id);

   /*
   * 用于查询所有的用户信息
   * */
    List<User> getAllUser();

    /*
    * 查询用户总数量
    * */
    Integer getCount();

    /*
    * 根据ID查询用户信息为map集合
    * */
    Map<String,Object> getUserByIdToMap(@Param("id")Integer id);

    /*
    * 查询所有的用户信息为一个map集合
    * */
    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

}
