package com.tfswufe.web;

import com.tfswufe.entity.User;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertUserServlet",urlPatterns = "/UserServlet1")
public class InsertUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String pwd1 = request.getParameter("pwd1");
        if (pwd.equals(pwd1)){
            String sex = request.getParameter("sex");
            int age = Integer.parseInt(request.getParameter("age"));
            Long tel = Long.valueOf(request.getParameter("tel"));
            String address = request.getParameter("address");
            String role = request.getParameter("role");
            User user = new User(0,name,sex,age,tel,address,role,pwd);
            Services services = new Services();
            Boolean b = services.InsertUserServices(user);
            if (b == true){
                response.sendRedirect("userAdmin.jsp");
            }else {
                request.setAttribute("msg","添加用户信息失败！");
                request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("msg","两次输入的密码不相同，添加失败！");
            request.getRequestDispatcher("userAdd.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
