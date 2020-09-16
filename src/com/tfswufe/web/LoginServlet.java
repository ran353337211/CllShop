package com.tfswufe.web;

import com.tfswufe.entity.User;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        Services services = new Services();
        User user = services.LoginServices(name,pwd);
        if (user != null){
            HttpSession session = request.getSession();
            session.setAttribute("User",user);
            response.sendRedirect("admin_index.jsp");
        }else {
            System.out.println("登录失败!");
            request.setAttribute("msg","用户名或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
