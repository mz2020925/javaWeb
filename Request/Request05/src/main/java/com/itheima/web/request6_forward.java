package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "request6", value = "/request6")
public class request6_forward extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求访问request6...");
        // 先做一部分处理
        req.setAttribute("name", "张明志");
        req.setAttribute("age", "123");
        req.setAttribute("addr", "合肥");
        req.setAttribute("gender", "男");

        // 把请求req对象转发到"/request7"，它会再做一部分处理
        req.getRequestDispatcher("/request7").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
