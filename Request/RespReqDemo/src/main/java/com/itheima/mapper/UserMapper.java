package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    // 虽然使用注解开发，但是resources中同路径下依然要写UserMapper映射文件，
    // 这里的注解内容到时候还是会自动转移到xml文件中构成标签的
    @Select("select * from tb_user where username = #{username} and password = #{password}")  // #{username}就是xml文件中的标签的变量名
    User select(@Param("username") String username,@Param("password")  String password);
    // @Param("")中的变量名就是xml文件中的标签的变量名，也就是#{username}，将来主函数调用select方法，
    // 把参数传递给该方法的形参变量，形参变量再把参数传递给标签的变量名
}
