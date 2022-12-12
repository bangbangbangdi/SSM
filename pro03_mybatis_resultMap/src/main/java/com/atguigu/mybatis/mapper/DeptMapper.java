package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /*
    * 通过分布查询查询员工以及所对应部门信息的第二步
    * */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /*
    * 查询部门以及部门中员工的信息
    * */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);


    /*
    * 通过分步查询查询部门以及部门中的员工信息的第一步
    * */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

}
