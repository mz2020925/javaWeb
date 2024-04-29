package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/request3")
public class request3_universial_parse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 打印请求方式
        // System.out.println("GET...");
        // 1.req.getParameterMap() -- 获取所有 参数名与参数值 的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // username:zmz
            System.out.print(key+":");

            // 获取值:
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
        System.out.println("----------");

        // 2.req.getParameterValues() -- 根据key获取 参数值 的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.print(hobby+" ");
        }
        System.out.println();
        System.out.println("----------");

        // 3.req.getParameter() -- 根据key获取单个 参数值
        String usename = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(usename);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
