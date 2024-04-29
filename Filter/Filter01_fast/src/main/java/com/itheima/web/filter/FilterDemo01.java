package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前过滤器执行了"); // 放行前servletRequest有数据，可以进行一些操作。servletResponse是没有数据的
        filterChain.doFilter(servletRequest, servletResponse);  // 执行放行"/*"操作，如果不写这句代码，就不放行"/*"
        System.out.println("放行后过滤器执行了"); // 放行后servletResponse是有数据了，可以进行一些操作。
    }

    @Override
    public void destroy() {

    }
}
