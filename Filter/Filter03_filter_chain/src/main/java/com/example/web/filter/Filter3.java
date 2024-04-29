package com.example.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Filter3 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器3 放行前的操作。。。");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器3 放行后的操作。。。");
    }

    @Override
    public void destroy() {

    }
}
