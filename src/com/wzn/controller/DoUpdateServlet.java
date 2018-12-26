package com.wzn.controller;

import com.wzn.pojo.Product;
import com.wzn.service.IProductService;
import com.wzn.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    private IProductService service=new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int inv=Integer.parseInt(req.getParameter("inv")) ;
        int brandId= Integer.parseInt(req.getParameter("brandId"));
        double price = Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");  //通过这个方法获取标签属性name的值
        String url = req.getParameter("url");
        Product p = new Product();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        p.setDes(des);
        p.setUrl(url);
        p.setInv(inv);
        p.setBrandId(brandId);
        //System.out.println(p);  //测试
        service.update(p);
        /*重定向*/
        resp.sendRedirect("productList");
    }
}
