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
     *   map集合参数方式传递参数
     */
    List<Brand> selectByCondition(Map map);
}
