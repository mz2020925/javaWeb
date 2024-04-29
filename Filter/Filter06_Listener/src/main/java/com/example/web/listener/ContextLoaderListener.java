package com.example.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    // 该接口用于监听ServletContext对象
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源
        System.out.println("`ServletContext` 对象被创建了会自动执行contextInitialized方法");
        // `ServletContext` 代表整个web应用，在服务器启动的时候，tomcat会自动创建该对象。在服务器关闭时会自动销毁该对象。
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("`ServletContext` 对象被销毁时会自动执行contextDestroyed方法");
    }
}
