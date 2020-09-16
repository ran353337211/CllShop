package com.tfswufe.web;

import com.tfswufe.entity.Bill;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "InsertCheckServlet",urlPatterns = "/InsertServlet")
public class InsertCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        int number = Integer.parseInt(request.getParameter("number"));
        Double money = Double.valueOf(request.getParameter("money"));
        String notice = request.getParameter("notice");
        String supname = request.getParameter("supname");
        String paymoney = request.getParameter("paymoney");
        String time = request.getParameter("time");
        Bill bill = new Bill(0,name,number,money,paymoney,supname,notice,time);
        Services services = new Services();
        Boolean b = services.InsertCheckServices(bill);
        if (b == true){
            response.sendRedirect("admin_bill_list.jsp");
        }else {
            request.setAttribute("msg","账单添加失败");
            request.getRequestDispatcher("modify.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
