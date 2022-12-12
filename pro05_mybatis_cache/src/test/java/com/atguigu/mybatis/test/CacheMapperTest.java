package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheMapperTest {

    /*
    * MyBatis的一级缓存（默认开启）：
    *   mybatis的一级缓存是sqlSession级别的，即通过同一个sqlSession查询的数据会被加载到缓存中
    *   在同一个sqlSession内再次查询同一条数据，会从缓存中直接获取
    *   使sqlSession失效的四种情况
    *       a.不同的sqlSession对应不同的一级缓存
    *       b.同一个sqlSession但是查询条件不同
    *       c.同一个sqlSession两次查询之间执行了任意一次增删改(清空缓存)
    *       d.同一个sqlSession两次查询期间手动清空了缓存
    * */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp1);
        Emp emp2 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp2);

        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpByEmpId(3);
        System.out.println("emp3 = " + emp3);
    }

}