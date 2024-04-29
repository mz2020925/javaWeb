package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    /*MyBatis 参数封装：
        * 单个参数：
            1. POJO类型：直接使用，属性名 和 参数占位符名称 一致
            2. Map集合：直接使用，键名 和 参数占位符名称 一致
            3. Collection：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",collection集合);
                map.put("collection",collection集合);
            4. List：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",list集合);
                map.put("collection",list集合);
                map.put("list",list集合);
            5. Array：封装为Map集合，可以使用@Param注解，替换Map集合中默认的arg键名
                map.put("arg0",数组);
                map.put("array",数组);
            6. 其他类型：直接使用
            ***总结以上就是以后单个参数要使用@Param注解来传递参数。***
        * 多个参数：封装为Map集合,可以使用@Param注解，替换Map集合中默认的arg键名
            map.put("arg0",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)
            ---------------@Param("username")
            map.put("username",参数值1)
            map.put("param1",参数值1)
            map.put("param2",参数值2)
            map.put("agr1",参数值2)
            ***多个参数可以通过多个注解，对象，或者map集合(是在测试文件中自己new然后put()的map集合)传递，前面都讲过。***
     */
    User select(@Param("username") String username,@Param("password")String password);
}
