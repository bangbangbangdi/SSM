package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    /*
    * 根据EmpId查询员工信息
    * */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

}