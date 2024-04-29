package com.example.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Filter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器1 进入前的操作。。。");  // 就像一个门卫，你进来之前要打卡验证
        filterChain.doFilter(servletRequest, servletResponse);  // 出去之后，还要打卡验证
        System.out.println("过滤器1 出去后的操作。。。");
    }

    @Override
    public void destroy() {

    }
}
