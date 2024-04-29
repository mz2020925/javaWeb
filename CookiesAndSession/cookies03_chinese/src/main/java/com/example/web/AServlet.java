package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/a")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // 从请求中提取数据，创建cookie对象并返回给浏览器

        // 1.创建Cookie对象
        String value = "张三";
        value = URLEncoder.encode(value, "UTF-8");  // Cookies不能保存汉字，需对汉字进行URL(utf-8)编码
        Cookie cookie = new Cookie("username", value);

        // 把cookie对象返回
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
