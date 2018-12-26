package com.wzn.service;

import com.wzn.pojo.Brand;

import java.util.List;

public interface IBrandService {
    public List<Brand> getLists();
    public int add(Brand b);
}
