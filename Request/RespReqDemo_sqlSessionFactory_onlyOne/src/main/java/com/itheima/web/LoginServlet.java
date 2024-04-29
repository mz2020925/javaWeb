package com.itheima.web;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接受用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.调用MyBatis完成查询
        // 2.1获取SqlSessionFactory对象
        // String resource = "mybatis-config.xml";
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 可以看出上面三行代码属于重复代码，不利于后期的维护，并且SqlSessionFactory工厂类为了提高效率，一般只创建一次
        // 所以我们创建了 工具类、静态成员变量、静态代码块、静态方法来解决上述缺陷，如下
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2.3获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.4调用方法
        User user = userMapper.select(username, password);
        // 2.5释放资源
        sqlSession.close();


        // 3.判断登录成功与否并通过 字符输出流对象 打印"登陆成功"或者"登陆失败"
        // 创建字符输出流对象，并设置contentType
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        if (user!=null){
            // 登陆成功
            writer.write("登陆成功");
        }else {
            // 登陆失败
            writer.write("登陆失败");
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
