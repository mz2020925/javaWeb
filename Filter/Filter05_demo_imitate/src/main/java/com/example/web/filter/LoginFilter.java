package com.example.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 判断访问资源的路径是否和登陆注册相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        // 获取当前访问的资源路径
        String url = httpServletRequest.getRequestURL().toString();
        // 循环判断url是否在urls里面
        for (String s : urls) {
            if(url.contains(s)){
                //访问资源的路径和登陆注册相关，放行
                filterChain.doFilter(servletRequest, servletResponse);
            }
            return;
        }

        // 1.判断session中是否有user
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user!=null){
            // 用户登录过了
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            // 没有登陆，给出提示信息，跳转到登录页面
            httpServletRequest.setAttribute("login_msg", "您尚未登陆！");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

        @Override
    public void destroy() {

    }
}
