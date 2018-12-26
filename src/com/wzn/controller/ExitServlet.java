package com.wzn.controller;

import com.wzn.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] coo=req.getCookies();
        Map<String,Cookie> maps= CookieUtil.getCookie(coo);
        Cookie ucoo= maps.get("uname");
        Cookie coops=new Cookie("uname","");
        ucoo.setValue("");
        coops.setMaxAge(0);
        resp.addCookie(coops);
        HttpSession session= req.getSession();
        session.invalidate();
        resp.sendRedirect("login");
    }
}
