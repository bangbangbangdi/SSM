package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /*
    * 通过分布查询查询员工以及所对应部门信息的第二步
    * */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

}
