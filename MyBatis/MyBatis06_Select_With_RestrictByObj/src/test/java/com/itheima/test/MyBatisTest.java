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

        // 把参数封装到对象里面去,在下面brandMapper.selectByCondition()传递的就是对象brand
        // 在将来这个过程是自动化完成的
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();

    }
}
