package com.tfswufe.web;

import com.tfswufe.entity.Supplier;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertSupplierServlet",urlPatterns = "/addSupplier")
public class InsertSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String supname = request.getParameter("supname");
        String supnotice = request.getParameter("supnotice");
        String name = request.getParameter("name");
        Long suptel = Long.valueOf(request.getParameter("suptel"));
        String supaddress = request.getParameter("supaddress");
        String email = request.getParameter("email");
        Supplier supplier = new Supplier(0,supname,supnotice,name,suptel,supaddress,email);
        Services services = new Services();
        Boolean b = services.InsertSupplierServices(supplier);
        if (b == true){
            response.sendRedirect("providerAdmin.jsp");
        }else {
            request.setAttribute("msg","供应商信息添加失败！");
            request.getRequestDispatcher("providerAdmin.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
