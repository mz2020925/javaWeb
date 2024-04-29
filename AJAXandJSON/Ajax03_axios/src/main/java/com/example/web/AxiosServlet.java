package com.example.web;

import java.lang.String;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/axios-servlet")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是get请求");

        // 1.从请求体中获取参数username
        String username = req.getParameter("username");
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);  // 解决从请求中获取中文参数是乱码的问题
        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(username);

        // 返回响应
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("hello axios, 参数是 "+username+" by get request!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是post请求");

        // 1.从请求体中获取参数username
        req.setCharacterEncoding("UTF-8");  // 解决请求post中文乱码问题，post请求方式中，获取参数的方式getReader()是流的方式
        String username = req.getParameter("username");
        System.out.println(username);

        resp.setCharacterEncoding("UTF-8");  // 解决post响应中文乱码问题，
        resp.getWriter().write("hello axios, 参数是 "+username+" by post request!");
    }
}
