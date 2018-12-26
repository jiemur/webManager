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
@WebServlet("/updateB")
public class UpdateBrandServlet extends HttpServlet {
    private IBrandService service=new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id=Integer.parseInt(req.getParameter("id"));
        Brand brand=service.getOne(id);
        System.out.println(brand);
        req.setAttribute("brand",brand);
        req.getRequestDispatcher("updateBrand.jsp").forward(req,resp);

}
}
