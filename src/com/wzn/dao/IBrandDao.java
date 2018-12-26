package com.wzn.dao;

import com.wzn.pojo.Brand;

import java.util.List;

public interface IBrandDao {
    public List<Brand> getLists();
    public int add(Brand b);
}
