package com.example.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/*
拦截路径有如下四种配置方式：(就是@WebFilter("/hello.jsp"))

* 拦截具体的资源：/index.jsp：只有访问index.jsp时才会被拦截
* 目录拦截：/user/*：访问/user下的所有资源，都会被拦截
* 后缀名拦截：*.jsp：访问后缀名为jsp的资源，都会被拦截
* 拦截所有：/*：访问所有资源，都会被拦截。上一个模块中就是拦截所有路径
* */
@WebFilter("/hello.jsp")
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前过滤器执行了"); // 放行前servletRequest有数据，可以进行一些操作。servletResponse是没有数据的
        filterChain.doFilter(servletRequest, servletResponse);  // 执行放行"hello.jsp"操作，如果不写这句代码，就不放行"/*"
        System.out.println("放行后过滤器执行了"); // 放行后servletResponse是有数据了，可以进行一些操作。
    }

    @Override
    public void destroy() {

    }
}
