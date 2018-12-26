package com.wzn.controller;

import com.wzn.service.BrandServiceImpl;
import com.wzn.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteB")
public class DeleteBrandServlet extends HttpServlet {
    private IBrandService service=new BrandServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        service.delete(id);
        resp.sendRedirect("brandList");

    }
}
