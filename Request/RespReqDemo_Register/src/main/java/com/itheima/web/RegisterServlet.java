package com.itheima.web;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收用户注册数据并封装数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 2.调用MyBatis完成查询
        // 2.1获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.3获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.4调用方法
        User user1 = userMapper.selectByUsername(username);


        // 3.判断注册用户名是否存在
        resp.setContentType("text/html;charset=utf-8");  // 获取字符输出流对象，并设置contentType
        PrintWriter writer = resp.getWriter();
        if (user1==null){
            // 注册用户名不存在
            userMapper.add(user);
            sqlSession.commit();
            writer.write("注册成功");
        }else {
            // 注册用户名已存在
            writer.write("用户名已存在");
        }

        // 4.释放资源
        sqlSession.close();


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
