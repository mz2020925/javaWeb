package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/b")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 浏览器会把自己保存的 当前服务器地址下 的所有的Cookie对象放到数组中全部发给 当前服务器，所以后端选取需要的Cookie对象
        // 1.获取Cookie数组
        Cookie[] cookies = req.getCookies();

        // 2.遍历数组
        for (Cookie cookie: cookies){
            // 3.获取cookie对象中的数据,从目前学习的来看，一个cookie对象就是一个键值对
            String name = cookie.getName();
            if (name.equals("username")){
                String value = cookie.getValue();
                // value是中文的URL编码形式，需要进行URL(utf-8)解码
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println("username: " + value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
