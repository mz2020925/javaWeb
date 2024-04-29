package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 一个Servlet，可以配置多个urlPattern
* urlPattern 配置规则
* ① 精确匹配
* ② 目录匹配
* ③ 扩展名匹配
* ④ 任意匹配
* */

@WebServlet(urlPatterns = {"/demo1", "/demo2"})
// @WebServlet("/user/select")  // 精确匹配 -- 必须写这个字符串
// @WebServlet("/user/*")  // 目录匹配 -- 匹配/user后面写啥无所谓
// @WebServlet("*.do")  // 扩展名匹配 -- 这个字符串不能以斜杠/开头
// @WebServlet("/")  // 任意匹配 -- 这里的字符串想些啥写啥，任意匹配有两种形式，另一种是"/*"
// @WebServlet("/*")  // 任意匹配
public class Servlet_urlPattern1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
