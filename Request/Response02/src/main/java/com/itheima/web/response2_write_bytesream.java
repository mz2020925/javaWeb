package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "response2", value = "/response2")
public class response2_write_bytesream extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.读取文件到“流”
        FileInputStream fis = new FileInputStream("E:\\证件照\\QQ头像.jpg");
        // 2.获取response字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 3.完成“流”的copy
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes))!=-1){
            outputStream.write(bytes, 0, len);
        }
        fis.close();


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
