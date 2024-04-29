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
     *   散装方式传递参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      这种写法的参数传递，status会传给BrandMapper.xml中的#{status}，
     *      这种写法的参数传递，companyName会传给BrandMapper.xml中的#{companyName}，
     *      这种写法的参数传递，brandName会传给BrandMapper.xml中的#{brandName}，
     */
    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

}
