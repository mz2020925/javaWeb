package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/*
 * 本类讲解Servlet的getServletConfig(), getServletInfo()方法
 * */
@WebServlet(urlPatterns = "/servlet03", loadOnStartup = 1)
public class Servlet03 implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Servlet Servlet03 init...");
    }

    /**
     * 此方法就是返回init()方法中的ServletConfig类型的参数的值，如何实现，添加成员变量
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    /**
     * 此方法返回一些厂商等信息，无用，一般返回return "";或者return null;
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
