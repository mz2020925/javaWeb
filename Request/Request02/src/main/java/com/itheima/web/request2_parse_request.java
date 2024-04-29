package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/request2")
public class request2_parse_request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * String getMethod() -- 获取请求方式: 如"GET"
        * String getContextPath() -- 获取虚拟目录(项目访问路径):如"/Request02"
        * StringBuffer getRequestURL() -- 获取URL(统一资源定位符):如"http://localhost/Request02/request1"
        * String getRequestURI() -- 获取URI(统一资源标识符):如"/Request02/request1"
        * String getQueryString() -- 获取请求参数(GET方式):如"username=zmz&password=123"
        * */
        // 获取请求方式: 如"GET"
        String method = req.getMethod();
        System.out.println(method);

        // 获取虚拟目录(项目访问路径):如"/Request02"
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        // 获取URL(统一资源定位符):如"http://localhost/Request02/request1"
        StringBuffer url = req.getRequestURL();
        System.out.println(url);

        // 获取URI(统一资源标识符):如"/Request02/request1"
        String uri = req.getRequestURI();
        System.out.println(uri);

        // 获取请求参数(GET方式):如"username=zmz&password=123"
        String queryString = req.getQueryString();
        System.out.println(queryString);

        /*
        * 对于请求头的数据，格式为 key: value
        * 所以根据请求头名称获取对应值的方法为
        *  String getHeader(String name)
        * */
        String agent = req.getHeader("user-agent");
        System.out.println(agent);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过流的方式的方法获取POST请求体（请求参数）
        // 1.获取字符输入流
        BufferedReader br = req.getReader();
        // 2.读取数据
        String line = br.readLine();
        System.out.println(line);
    }
}
