package com.example.web;


import com.alibaba.fastjson.JSON;
import com.example.pojo.Brand;
import com.example.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/select-all-users")
public class SelectAllServlet extends HttpServlet {
    private BrandService branService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.调用service查询
        List<Brand> brands = branService.selectAll();
        // 2.将集合转换为JSON数据，序列化
        String jsonString = JSON.toJSONString(brands);
        // 3.返回响应数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
