package com.tfswufe.web;

import com.tfswufe.entity.Bill;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindCheckServlet",urlPatterns = "/findAllCheckByTag")
public class FindCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String paymoney = request.getParameter("paymoney");
        Services services = new Services();
        List<Bill> list = services.SelectCheckServices(name,paymoney);
        request.setAttribute("list",list);
        request.getRequestDispatcher("admin_bill_list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
