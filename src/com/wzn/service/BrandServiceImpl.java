package com.wzn.service;

import com.wzn.dao.BrandImpl;
import com.wzn.dao.IBrandDao;
import com.wzn.pojo.Brand;
import com.wzn.utilTest.JdbcUtil;

import java.util.List;

public class BrandServiceImpl implements IBrandService {
    private IBrandDao dao=new BrandImpl();
    @Override
    public List<Brand> getLists() {
        return dao.getLists();
    }

    @Override
    public int add(Brand b) {
        return dao.add(b);
    }

    @Override
    public Brand getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public int update(Brand brand) {
        return dao.update(brand);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }
}
