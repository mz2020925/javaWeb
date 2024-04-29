package com.example.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/a")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求中提取数据，创建cookie对象并返回给浏览器

        // 1.创建Cookie对象
        Cookie cookie = new Cookie("username", "zs");
        // 设置存活时间
        cookie.setMaxAge(60*60*24*7);
        // cookie.setMaxAge(-1);  // 负数是默认值，cookies存在内存中，关闭就没了
        // cookie.setMaxAge(0);  // 删除对应的Cookie

        // 把cookie对象返回
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}