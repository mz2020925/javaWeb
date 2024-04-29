package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet2")
public class Servlet2_request_response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用传进来的req对象, 获取”请求“被解析后的内容
        String name = req.getParameter("name");  // 在浏览器输入"localhost/servlet2?name=张明志"

        // 使用传进来的resp对象, 调取资源生成”响应“
        resp.setHeader("context-type", "text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+"，欢迎您！</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
