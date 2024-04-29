package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* Mapper代理开发——到底什么是Mapper代理开发？它有什么用？
*
* 3.使用SqlSession对象的方法getMapper，解析UserMapper接口的字节码文件，
* UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
* 接下来这里调用UserMapper接口中的抽象方法selectAll()，执行的“方法体”是UserMapper.xml这个sql映射文件中id=selectAll的“标签”(或者说是“标签”里的SQL命令)。
* 为什么它就会自己跑去执行xml文件中的内容呢，因为你写了sqlSession.getMapper(UserMapper.class)，看到这个它就知道了你要用 map代理开发的方式 完成 SQL命令的执行(也就是表的各种操作)。
* 之所以使用mapper代理开发的方式，是因为这种方式IDEA可以有代码提示，而且携带的过程中思考更容易。
* List<User> userList = userMapper.selectAll();// 上句代码和这句代码代替了：快速入门模块中的List<User> allUsers = sqlSession.selectList("UserMapper.selectAll");
*
* */

public class mybatis1_mapper {
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

        //3.使用SqlSession对象的方法getMapper，解析UserMapper接口的字节码文件，
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 接下来这里调用UserMapper接口中的抽象方法selectAll()，执行的“方法体”，是UserMapper.xml这个sql映射文件中id=selectAll的“标签”(或者说是“标签”里的SQL命令)
        // 为什么它就会自己跑去执行xml文件中的内容呢，因为你写了sqlSession.getMapper(UserMapper.class)，看到这个它就知道了你要用 map代理开发的方式 完成 SQL命令的执行(也就是表的各种操作)
        // 之所以使用mapper代理开发的方式，是因为这种方式IDEA可以有代码提示，而且携带的过程中思考更容易
        List<User> userList = userMapper.selectAll();// 上句代码和这句代码代替了：List<User> allUsers = sqlSession.selectList("UserMapper.selectAll");
        System.out.println(userList);
        //4. 释放sqlSession资源
        sqlSession.close();

    }
}
