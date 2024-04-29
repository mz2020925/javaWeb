package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    // 使用注解解决简单的SQL命令
    // 使用xml解决复杂的SQL命令(如动态SQL命令)
    // 虽然使用注解开发，但是resources中同路径下依然要有UserMapper映射文件，只是映射文件中不用写具体的实现了
    // 这里的注解内容到时候还是会自动转移到xml文件中构成标签的
    @Select("select * from tb_user where id=#{id} ")
    User selectById(int id);
}
