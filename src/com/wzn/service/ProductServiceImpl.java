package com.wzn.service;

import com.wzn.dao.IProductDao;
import com.wzn.dao.ProductImpl;
import com.wzn.pojo.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
   private IProductDao dao=new ProductImpl();
    @Override
    public List<Product> getLists() {
        return dao.getLists();
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int update(Product product) {
        return dao.update(product);
    }

    @Override
    public Product getOne(int id) {
        return dao.getOne(id);
    }
}
