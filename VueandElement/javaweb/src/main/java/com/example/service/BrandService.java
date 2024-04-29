package com.example.service;

import com.example.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();
}
