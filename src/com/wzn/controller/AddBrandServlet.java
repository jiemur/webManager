package com.wzn.controller;

import com.wzn.pojo.Brand;
import com.wzn.service.BrandServiceImpl;
import com.wzn.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addB")
public class AddBrandServlet extends HttpServlet {
    private IBrandService service=new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        int id=Integer.parseInt(req.getParameter("id"));
        String des= req.getParameter("des");
        Brand b=new Brand();
        b.setName(name);
        b.setDes(des);
        b.setId(id);
        service.add(b);
        resp.sendRedirect("brandList");


    }
}
