package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "request5", value = "/request5")
public class request5_get_decode extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.下面这句修改“流”的解码方式不能少，因为这段代码是doGet()和doPost公用的。
        //   好吧这句代码可以少，因为下面解决解析GET”请求“URL包含的参数值乱码问题的方法适用于POST
        // 1.1这句代码解决解析POST“请求体”乱码的问题，
        req.setCharacterEncoding("utf-8");
        // 2.req.getParameter() -- 根据key获取单个 参数值
        String usename = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(usename);
        System.out.println(password);
        // 3.下面代码解决GET“请求”URL中包含的参数乱码的问题
        //   乱码的原因：get.html(“请求体”中的参数值就是从这个页面生成的)编码方式是utf-8，
        //   但是Tomcat解析”请求体“中的参数值，是按照ISO-8859-1编码方式(写死的，改不了)解码的
        byte[] bytes = usename.getBytes(StandardCharsets.ISO_8859_1);
        String username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("解决乱码后："+usename);


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
