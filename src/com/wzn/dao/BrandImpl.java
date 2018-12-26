package com.wzn.dao;

import com.wzn.pojo.Brand;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandImpl implements IBrandDao {
    @Override
    public List<Brand> getLists() {
        return JdbcUtil.executQuery("select * from brand", new RowMap<Brand>() {
            @Override
            public Brand rowMapping(ResultSet rs) {
                Brand b=new Brand();
                try {
                    b.setId(rs.getInt("brand_id"));
                    b.setDes(rs.getString("brand_des"));
                    b.setName(rs.getString("brand_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return b;
            }
        }, null);
    }

    @Override
    public int add(Brand b) {
        int a= JdbcUtil.executeUpdate("insert into brand(brand_id,brand_name,brand_des) values(?,?,?)",b.getId(),b.getName(),b.getDes());
        return a;
    }
}
