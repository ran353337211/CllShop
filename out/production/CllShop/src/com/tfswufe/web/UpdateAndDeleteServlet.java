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

@WebServlet(name = "UpdateAndDeleteServlet",urlPatterns = "/UDUserServlet")
public class UpdateAndDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        Services services = new Services();
        if (action.equals("findUserById")){
            //修改的操作
            int id = Integer.parseInt(request.getParameter("id"));
            User user = services.SelectUserByIdServices(id);
            request.setAttribute("user",user);
            request.getRequestDispatcher("updateUser.jsp").forward(request,response);
        }else if (action.equals("deleteById")){
            //删除的操作
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("User");
            int id1 = user.getId();
            if (id == id1){
                request.setAttribute("msg","您不能删除自己的信息！");
                request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
            }else {
                int i = services.DeleteUserServices(id);
                if (i != 0){
                    request.setAttribute("msg","删除成功！");
                    response.sendRedirect("userAdmin.jsp");
                }else {
                    request.setAttribute("msg","删除失败！");
                    request.getRequestDispatcher("userAdmin.jsp").forward(request,response);
                }
            }
        }else if (action.equals("updateUserById")){
            //修改的操作
            System.out.println("进入修改了");
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            int age = Integer.parseInt(request.getParameter("age"));
            Long tel = Long.valueOf(request.getParameter("tel"));
            String address = request.getParameter("address");
            String role = request.getParameter("role");
            //修改之后的user
            User user1 = new User(id,name,sex,age,tel,address,role);
            int i = services.UpdateUserServices(user1);
            //查询没修改之前的user
            User user = services.SelectUserByIdServices(id);
            if (i != 0){
                response.sendRedirect("userAdmin.jsp");
            }else {
                request.setAttribute("msg","修改失败！");
                request.setAttribute("user",user);
                request.getRequestDispatcher("updateUser.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
