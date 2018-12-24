package com.wzn.dao;

import com.wzn.pojo.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> getLists();
    public int delete (int id);
    public int update(Product product);
    public Product getOne(int id);
}
