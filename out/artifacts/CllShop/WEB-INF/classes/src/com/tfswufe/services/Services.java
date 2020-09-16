package com.tfswufe.services;

import com.tfswufe.dao.Dao;
import com.tfswufe.dao.MybatisDao;
import com.tfswufe.entity.Bill;
import com.tfswufe.entity.PageBean;
import com.tfswufe.entity.Supplier;
import com.tfswufe.entity.User;
import com.tfswufe.tool.MybatisTool;

import java.sql.SQLException;
import java.util.List;

public class Services {

    /**登录的业务逻辑方法*/
    public User LoginServices(String name,String pwd){
        MybatisDao mybatisDao = new MybatisDao();
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        User user1 = mybatisDao.LoginDao(user);
        return user1;
    }

    /**查询商品的业务逻辑方法*/
    public List SelectCheckServices(String name,String paymoney){
        MybatisDao mybatisDao = new MybatisDao();
        Bill bill = new Bill();
        bill.setName(name);
        bill.setPaymoney(paymoney);
        List<Bill> list = mybatisDao.SelectCheckDao(bill);
        return list;
    }

    /**添加商品信息的业务逻辑方法*/
    public Boolean InsertCheckServices(Bill bill){
//        String name,int number,Double money,String notice,String supname,String paymoney,String time;
        MybatisDao mybatisDao = new MybatisDao();
        int i = mybatisDao.InsertCheckDao(bill);
        Boolean b = false;
        if (i != 0){
            b = true;
            System.out.println("添加商品成功！");
        }else {
            System.out.println("添加商品失败！");
        }
        return b;
    }

    /**查询供应商信息的业务逻辑方法*/
    public List<Supplier> SelectSupplierServices(String providerName, String providerDesc){
        Dao dao = new Dao();
        List<Supplier> list = null;
        try {
            list = dao.SelectSupplierDao(providerName, providerDesc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for (Supplier supplier:list) {
//            System.out.println(supplier);
//        }
        return list;
    }

    /**添加供应商信息的业务逻辑方法*/
    public Boolean InsertSupplierServices(Supplier supplier){
        Dao dao = new Dao();
        int i = 0;
        Boolean b = false;
        try {
            i = dao.InsertSupplierDao(supplier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i != 0){
            b = true;
            System.out.println("添加供应商信息成功！");
        }else {
            System.out.println("添加供应商信息失败！");
        }
        return b;
    }

    /**查询用户信息的业务逻辑方法*/
    public List<User> SelectUserServices(String username, PageBean pageBean){
        Dao dao = new Dao();
        List<User> list = null;
        try {
            list = dao.SelectUserDao(username,pageBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**添加用户信息的业务逻辑方法*/
    public Boolean InsertUserServices(User user){
        Dao dao = new Dao();
        int i = 0;
        Boolean b = false;
        try {
            i = dao.InsertUserDao(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i != 0){
            b = true;
            System.out.println("添加用户信息成功！");
        }else {
            System.out.println("添加用户信息失败！");
        }
        return b;
    }

    /**查询用户信息总记录数的业务逻辑方法*/
    public int SelectCountUserServices(String name){
        Dao dao = new Dao();
        int total = 0;
        try {
            total = dao.SelectCountUserDao(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    /**根据用户id查询用户信息的业务逻辑方法*/
    public User SelectUserByIdServices(int id){
        Dao dao = new Dao();
        User user = null;
        try {
            user = dao.SelectUserByIdDao(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**修改用户信息的业务逻辑方法*/
    public int UpdateUserServices(User user){
        Dao dao = new Dao();
        int i = 0;
        try {
            System.out.println("进入services了");
            i = dao.UpdateUserDao(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**删除用户的业务逻辑方法*/
    public int DeleteUserServices(int id){
        Dao dao = new Dao();
        int i = 0;
        try {
            i = dao.DeleteUserDao(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
