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
@WebServlet("/doregister")
public class DoRegisterServlet extends HttpServlet {
    private IUserService service=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String uname=req.getParameter("unames");
       String pwd=req.getParameter("pwd");
       String pwds=req.getParameter("pwds");
       if(uname!=""){
           User u=service.getUser(uname);
           if(u==null){
               resp.getWriter().write("1");//可以注册
               if(pwd!=""&&pwds!=""){
                   if(pwd.equals(pwds)){
                       resp.getWriter().write("3");
                   }else{
                       resp.getWriter().write("4");
                   }
               }else{
                   resp.getWriter().write("5");
               }
           }else{
               resp.getWriter().write("2");
           }
       }

    }
}
