package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "response2", value = "/response2")
public class response1_write_charstream extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.响应行的状态码可以自动设置

        // 2.响应头
        // resp.setHeader("content-type", "text/html");  // 设置响应体内容是html的
        resp.setContentType("text/html;charset=utf-8");  // 设置响应体内容是html，并且把”流“生成”响应体“的编码方式是utf-8，这样生成的响应体中的”中文“就不会乱码了

        // 3.响应体
        // 3.1获取字符输出流
        PrintWriter writer = resp.getWriter();  // 这个流不用手动关闭
        // 3.2用writer对象把”流“ 生成 ”响应体“
        writer.write("hello this response body.");
        writer.write("<h1>hello this response body.</h1>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
