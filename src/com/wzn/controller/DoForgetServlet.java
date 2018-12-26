package com.wzn.controller;

import com.wzn.pojo.User;
import com.wzn.service.IProductService;
import com.wzn.service.IUserService;
import com.wzn.service.ProductServiceImpl;
import com.wzn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doForget")
public class DoForgetServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd=req.getParameter("pwd");
        String npwd=req.getParameter("npwd");
        User user=service.getUser(uname);
        if(uname!=null){
            if(pwd.equals(npwd)){
                resp.getWriter().write("1");
            }else {
                resp.getWriter().write("2");
            }
        }else{
            resp.getWriter().write("3");
        }


    }
}
