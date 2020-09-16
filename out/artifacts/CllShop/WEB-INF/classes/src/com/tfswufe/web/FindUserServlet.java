package com.tfswufe.web;

import com.tfswufe.entity.PageBean;
import com.tfswufe.entity.User;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindUserServlet",urlPatterns = "/UserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String now = request.getParameter("nowPage") == null || request.getParameter("nowPage") == ""?"1":request.getParameter("nowPage");
        int nowPage = Integer.parseInt(now);
        Services services = new Services();
        int total = services.SelectCountUserServices(name);
        PageBean pageBean = new PageBean();
        pageBean.setNowPage(nowPage);
        pageBean.setTotal(total);
        List<User> userList = services.SelectUserServices(name,pageBean);
        if (userList != null){
            request.setAttribute("userList",userList);
            request.setAttribute("nowPage",pageBean.getNowPage());
            request.setAttribute("total",pageBean.getTotal());
            request.setAttribute("pageCount",pageBean.getPageCount());
            request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
        }else {
            response.sendRedirect("userAdmin.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
