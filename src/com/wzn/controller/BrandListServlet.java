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
import java.util.List;

@WebServlet("/brandList")
public class BrandListServlet extends HttpServlet {
    private IBrandService service=new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Brand> lists= service.getLists();
       req.setAttribute("lists",lists);
       req.getRequestDispatcher("brand.jsp").forward(req,resp);
    }
}
