package com.itheima.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "response3", value = "/response3")
public class response3_write_bytesream2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.读取文件到“流”
        FileInputStream fis = new FileInputStream("E:\\证件照\\QQ头像.jpg");
        // 2.获取response字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 3.完成“流”的传递(把流从 fis 传到 outputStream ),并用outputStream对象，把“流”生成“响应体”
        IOUtils.copy(fis, outputStream);
        fis.close();

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
