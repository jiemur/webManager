package com.wzn.controller;

import com.wzn.pojo.User;
import com.wzn.service.IUserService;
import com.wzn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uname= req.getParameter("uname");
       String pwd=req.getParameter("pwd");
       User u= service.getUser(uname);
       if(u!=null){
           if(u.getPassword().equals(pwd)){
               resp.getWriter().write("1");
           } else{
               resp.getWriter().write("2");
           }
       }else{
           resp.getWriter().write("3");

       }

    }
}
