package com.wzn.service;

import com.wzn.dao.BrandImpl;
import com.wzn.dao.IBrandDao;
import com.wzn.pojo.Brand;

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
}
