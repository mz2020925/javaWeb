package com.itheima.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "response1", value = "/response1")
public class response1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1...");

        // 重定向
        // 1.设置响应行，响应行只有状态码302要设置
        // resp.setStatus(302);
        // 2.设置响应头Location
        // resp.setHeader("Location","/Response01/response2");  // 这里前面要加上”/Response01“虚拟目录，不能直接写”/response2“
        // 3.这里没有设置响应体
        // PrintWriter writer = resp.getWriter();  // 使用字符输出流的方式生成”响应体“，这里只是获取了字符输出流对象，下一步处理没有写
        // ServletOutputStream outputStream = resp.getOutputStream();  // 使用字节输出流的方式生成”响应体“

        // 1.上面的方式比较麻烦，简化方式完成重定向
        // resp.sendRedirect("/Response01/response2");

        // 2.重定向可以定向到服务器之外，就是可以定向的别的服务器那里
        resp.sendRedirect("http://www.baidu.com");

        // 3.关于虚拟目录的问题？
        // 由于pom.xml文件中会修改<path>...</path>虚拟目录，所以这里可以动态给定虚拟目录
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/response2");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
