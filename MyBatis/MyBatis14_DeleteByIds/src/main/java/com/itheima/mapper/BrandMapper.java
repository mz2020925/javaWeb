package com.itheima.mapper;


import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 批量删除
     */
    void deleteByIds(int[] ids);
    // void deleteByIds(@Param("ids") int[] ids);
}
