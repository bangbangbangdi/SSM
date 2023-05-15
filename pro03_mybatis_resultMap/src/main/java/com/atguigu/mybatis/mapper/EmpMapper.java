package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /*
    * 根据id查询员工信息
    * */
    Emp getEmpByEmpId(@Param("empId")Integer empId);

    /*
    * 获取员工以及所对应的部门
    * */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empID);

    /*
    * 通过分布查询查询员工以及所对应的部门信息的第一步
    * */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /*
    * 通过分步查询查询部门以及部门中的员工第二步
    * */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

    /**
     * @param null:
      * @return null
     * @author BangDi
     * @description TODO
     * @date 2023/5/12 10:11
     */
    Emp getEmpByMtlParamStepOne(@Param("empId")Integer empId);

}
