package com.itheima.mapper;


import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**条件查询
     * 条件查询中的参数传递：
     *   对象方式传递参数：对象的成员变量名称要和参数占位符名称一致
     */
    List<Brand> selectByCondition(Brand brand);
}
