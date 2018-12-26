package com.wzn.dao;

import com.wzn.pojo.Brand;
import com.wzn.pojo.Product;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Brand> lists() {
        return JdbcUtil.executQuery("select * from brand,product where brand.brand_id=product.brand_id", new RowMap<Brand>() {
            @Override
            public Brand rowMapping(ResultSet rs) {
                Brand b=new Brand();
                try {
                    b.setName(rs.getString("brand_name"));
                    b.setId(rs.getInt("brand_id"));
                    b.setDes(rs.getString("brand_des"));
                    Set<Product> sets=new HashSet<>();
                    Product p=new Product();
                    p.setId(rs.getInt("product_id"));
                    p.setName(rs.getString("product_name"));
                    p.setDes(rs.getString("product_des"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                    p.setInv(rs.getInt("product_inventory"));
                    p.setBrandId(rs.getInt("brand_id"));
                    sets.add(p);
                    b.setSets(sets);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return null;
            }
        }, null);
    }

    @Override
    public Brand getOne(int id) {
        return JdbcUtil.queryOne("select * from brand where brand_id=?", new RowMap<Brand>() {
            @Override
            public Brand rowMapping(ResultSet rs) {
                Brand b=new Brand();

                try {
                    b.setId(rs.getInt("brand_id"));
                    b.setName(rs.getString("brand_name"));
                    b.setDes(rs.getString("brand_des"));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return b;
            }
        }, id);
    }

    @Override
    public int update(Brand brand) {
        System.out.println(brand);
        int b=JdbcUtil.executeUpdate("update brand set brand_name=?,brand_des=? where brand_id=?",brand.getName(),brand.getDes(),brand.getId());
        return b;
    }

    @Override
    public int delete(int id) {
        return JdbcUtil.executeUpdate("delete from brand where brand_id=?",id);
    }


}

