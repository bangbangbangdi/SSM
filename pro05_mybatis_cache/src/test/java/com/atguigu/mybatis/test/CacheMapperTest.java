package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
    *
    * MyBatis的二级缓存（默认开启）：
    *   mybatis的二级缓存是sqlSessionFactory级别的，即通过一个sqlSessionFactory所获取的sqlSession对象查询的数据会被加入缓存中
    *   在通过同一个SessionFactory所获取的SqlSession查询相同的数据时，会直接从缓存中获取
    * MyBatis二级缓存开启的条件：
    *   a.在核心配置文件中，设置全局配置属性cacheEnable="true",默认为true，不需要设置
    *   b.在映射文件中设置标签<cache/>
    *   c.二级缓存必须在SqlSession关闭或提交后有效（在这之后才会被加入缓存中）
    *   d.查询的数据所转换的实体类类型必须实现序列化接口
    * 使二级缓存失效的情况：
    *   两次查询之间执行了任意的增删改，会使一二级缓存同时失效
    * 二级缓存的相关配置（了解）
    *   在mapper配置文件中添加的cache标签可以设置一些属性：
    *   A.eviction属性：回收缓存策略，默认使用的使LRU
    *       LRU（Least Recently Used）最近最少使用的：移除长时间不被使用的对象
    *       FIFO（First in First out）先进先出：按对象进入缓存的顺序来移除它们
    *       SOFT-软引用：移除基于垃圾回收器状态和软引用规则的对象
    *       WEAK-弱引用：更积极地移除基于垃圾回收器状态和弱引用规则的对象
    *   B.flushInterval属性：刷新间隔，单位毫秒
    *       默认情况下是不设置，也就是没有刷新间隔，缓存仅仅会在调用语句时刷新
    *   C.size属性：引用数目，正整数
    *       代表缓存最多可以存储多少个对象，太大容易导致内存溢出
    *   D.readOnly属性：只读，true/false
    *       true:只读缓存，会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改，这提供了很重要的性能优势
    *       false:读写缓存，会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是false
    *
    * MyBatis缓存查询的顺序：
    *   先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以直接拿来用
    *   如果二级缓存没有命中，再查询一级缓存
    *   如果一级缓存也没有命中，则直接查询数据库
    *   SqlSession关闭之后，一级缓存中的数据会写入二级缓存
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

    @Test
    public void testGetEmpByIdAndInsert(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp1);

        Emp emp3 = new Emp(null, "C", 30, "n");
        mapper.insertEmp(emp3);

        Emp emp2 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp2);
    }

    @Test
    public void testGetEmpByIdAndClearCache(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp1);
        sqlSession.clearCache();
        Emp emp2 = mapper.getEmpByEmpId(3);
        System.out.println("emp = " + emp2);
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEmpId(2);
        System.out.println("emp1 = " + emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEmpId(2);
        System.out.println("emp2 = " + emp2);
        sqlSession2.close();
    }
}