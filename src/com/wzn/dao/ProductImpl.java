package com.wzn.dao;

import com.wzn.pojo.Product;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductImpl implements IProductDao {
    @Override
    public List<Product> getLists() {
        return JdbcUtil.executQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product rowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setId(rs.getInt("product_id"));
                    p.setName(rs.getString("product_name"));
                    p.setDes(rs.getString("product_des"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                    p.setInv(rs.getInt("product_inventory"));
                    p.setBrandId(rs.getInt("brand_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return p;
            }
        }, null);
    }

    @Override
    public int delete(int id) {
        return JdbcUtil.executeUpdate("delete  from product where product_id=?",id);
    }

    @Override
    public int update(Product product) {

        int  a= JdbcUtil.executeUpdate("update product set  product_name=?,price=?,product_des=?,product_inventory=?,url=?,brand_id=? where product_id=?", product.getName(),product.getPrice(),product.getDes(),product.getInv(),product.getUrl(),product.getBrandId(),product.getId());
        return a;
    }

    @Override
    public Product getOne(int id) {
        return JdbcUtil.queryOne("select * from product where product_id=?", new RowMap<Product>() {
            @Override
            public Product rowMapping(ResultSet rs) {
                Product p=new Product();
                try {
                    p.setId(rs.getInt("product_id"));
                    p.setName(rs.getString("product_name"));
                    p.setDes(rs.getString("product_des"));
                    p.setPrice(rs.getDouble("price"));
                    p.setUrl(rs.getString("url"));
                    p.setInv(rs.getInt("product_inventory"));
                    p.setBrandId(rs.getInt("brand_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return p;
            }
        },id);
    }

    @Override
    public int add(Product product) {
        return JdbcUtil.executeUpdate("insert into product(product_name,price,product_des,url,product_inventory,brand_id) values(?,?,?,?,?,?)",product.getName(),product.getPrice(),product.getDes(),product.getUrl(),product.getInv(),product.getBrandId());
    }
}
