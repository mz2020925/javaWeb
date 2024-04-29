package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "request4", value = "/request4")
public class request4_post_decode extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 当"请求"方式是GET时，”请求体“的解析是通过方法 String getQueryString()。
        // 当"请求"方式是POST时，”请求体“的解析是通过”流“的方式；
        // 1.Tomcat中封装的Socket，在以”流“的方式解析POST”请求体”时，会涉及到解码的问题，因为解码方式不对应，所以会出现乱码。
        //   由于c.html中设置的编码方式utf-8，这里设置解码方式也应该是utf-8，解析POST"请求"就不会出现乱码了。
        //   注意：GET”请求“的”内容”是放在URL中的，解析URL是另外一种方式了。
        req.setCharacterEncoding("utf-8");
        // 2.req.getParameter() -- 根据key获取单个 参数值
        String usename = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(usename);
        System.out.println(password);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
