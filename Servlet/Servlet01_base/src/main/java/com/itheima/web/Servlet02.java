package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
 * 本类讲解Servlet的init(), service(), destroy()方法
 * */
@WebServlet(urlPatterns = "/servlet02", loadOnStartup = 1)
public class Servlet02 implements Servlet {
    /**初始化方法
     * 1.调用时机：默认情况下，".../servlet02"被第一次访问的时候调用此方法
     * 2.调用次数：1次，后面刷新浏览器不会被调用
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet Servlet02 init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**Tomcat收到浏览器”请求“，解析后发现浏览器想访问URL".../servlet02"，
     * 接下来Tomcat会调用这里的Servlet02.service()产生的”响应“的响应体
     *
     * 1.调用时机：每一次".../servlet02"被访问时调用
     * 2.调用次数：可以多次调用，后面刷新浏览器就会被调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet02 Hello World~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**销毁方法
     *
     * 1.调用时机：内存释放或者服务器关闭的时候，Servlet对象需要销毁，此时调用此方法
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("Servlet Servlet02 destroy...");
    }
}
