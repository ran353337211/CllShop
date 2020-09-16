package com.tfswufe.web;

import com.tfswufe.entity.Supplier;
import com.tfswufe.services.Services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindSupplierServlet",urlPatterns = "/merchantsSelect")
public class FindSupplierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String providerName = request.getParameter("providerName");
        String providerDesc = request.getParameter("providerDesc");
        Services services = new Services();
        List<Supplier> list = services.SelectSupplierServices(providerName,providerDesc);
        if (list != null){
            request.setAttribute("suppliers",list);
            request.getRequestDispatcher("providerAdmin.jsp").forward(request, response);
        }else {
            response.sendRedirect("providerAdmin.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
