package com.itheima.mapper;

import com.itheima.pojo.User;
import java.util.List;

/*
 * 使用Mapper代理方式，必须满足以下要求：
 * 1.定义与SQL映射文件同名的Mapper接口，并且将Mapper接口和SQL映射文件放置在同一目录下。
 * (这里又涉及到编译后，java和resources中的文件都会被放到target文件夹中的classes文件夹下)
 * 2.设置sql映射文件的namespace属性为Mapper接口全限定名
 * 3.在 Mapper 接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
 * */
public interface UserMapper {
    List<User> selectAll();
}
