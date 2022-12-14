package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MGBTest {

    @Test
    public void testSelectByPrimaryKey(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 根据id查询数据
        /*
        Emp emp = mapper.selectByPrimaryKey(2);
        System.out.println("emp = " + emp);
        */
        // 查询所有数据
        /*
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(System.out::println);
        */
        // 根据条件查询数据
        /*
        EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("xx").andAgeGreaterThanOrEqualTo(20);
        example.or().andGenderEqualTo("n");
        List<Emp> list = mapper.selectByExample(example);
        list.forEach(System.out::println);
        */
        Emp emp = new Emp(1, "熊熊", null, "n");
        // 测试普通修改功能
        //mapper.updateByPrimaryKey(emp);
        // 测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);

    }

}
