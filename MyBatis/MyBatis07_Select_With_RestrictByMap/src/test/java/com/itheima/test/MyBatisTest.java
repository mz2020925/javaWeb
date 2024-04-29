package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyBatisTest {
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        /*处理参数
        * 1.使用like关键字，条件表达式是：select * from tb_brand where status=1 and companyName like '%华为%' and brandName like '%华为%'
        * 2.可以使用通配符"_"、"%"进行占位
        * 3."_"代表一个任意字符
        * 4."%"表示若干个任意字符
        * */
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 把参数封装到Map集合里面去
        // Map集合里面的 键名 就是 SQL映射文件中SQL命令的占位符名字#{status}
        // Map集合里面的 值名 就是 接收到的变量名
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }
}
