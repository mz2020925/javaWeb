package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/Servlet_HttpServlet", loadOnStartup = 1)
public class Servlet_HttpServlet extends HttpServlet {
    /*
    * 下面根据请求方式的不同，调用不同方法执行不同的代码。
    * 为什么要这样？这样起到了什么作用？看视频要搞明白。
    * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST...");
    }
}
