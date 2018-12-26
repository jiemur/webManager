package com.wzn.dao;

import com.wzn.pojo.Brand;
import com.wzn.pojo.Product;

import java.util.List;

public interface IBrandDao {
    public List<Brand> getLists();
    public int add(Brand b);
    public List<Brand> lists();
    public Brand getOne(int id);
    public int update(Brand brand);
    public int delete(int id);
}
