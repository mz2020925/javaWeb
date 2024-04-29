package com.itheima;

import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* 如何使用MyBatis的快速入门——使用的是xml配置文件的方式来使用MyBatis
* */
public class mybatis1_fast {
    public static void main(String[] args) throws IOException {
        // 1.加载mybatis的核心配置文件，获取SqlSessionFactory对象，因为下面要通过SqlSessionFactory对象 获取 SqlSession对象
        // 1.1配置文件在哪里
        String resource = "mybatis-config.xml";
        // 1.2把 配置文件中的字符串 转换为 输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.3根据 输入流中的信息(包含：1.要连接哪个数据库(连接"钥匙"已经写好)；2.要加载的sql映射文件有哪些、在哪里)，
        // 创建出SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，它能够实现sql映射文件中的SQL命令的执行
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.使用SqlSession对象的方法执行 sql映射文件 中的 “标签”(包含sql命令的标签)，
        // 这个方法还能自动把结果集装进List集合中作为返回值
        List<User> allUsers = sqlSession.selectList("UserMapper.selectAll");
        System.out.println(allUsers);
        //4. 释放sqlSession资源
        sqlSession.close();

    }
}
