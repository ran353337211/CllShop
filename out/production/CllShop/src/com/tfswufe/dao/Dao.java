package com.tfswufe.dao;

import com.tfswufe.entity.Bill;
import com.tfswufe.entity.PageBean;
import com.tfswufe.entity.Supplier;
import com.tfswufe.entity.User;
import com.tfswufe.tool.Tool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    /**
     * 登录 √
     */
    public User LoginDao(String name,String pwd) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句
        String sql = "SELECT * FROM users WHERE name = ? and pwd = ?";
        //3.创建SQL执行器
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.传参
        ps.setString(1,name);
        ps.setString(2,pwd);
        //5.执行SQL语句，获得结果集
        ResultSet resultSet = ps.executeQuery();
        //6.判断结果集中是否有数据
        User user = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String role = resultSet.getString("role");
            user = new User(id,name1,role);
        }
        //7.关闭连接
        Tool.CloseAll(connection,ps,resultSet);
        return user;
    }

    /**
     *查询订单信息的方法 √
     */
    public List SelectCheckDao(String Name,String PayMoney) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句（并且判断）
        PreparedStatement ps = null;
        if ((Name != null && Name != "") && (PayMoney != null && PayMoney != "")){
            String sql = "SELECT * FROM bill WHERE name LIKE ? and paymoney LIKE ?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+Name+"%");
            ps.setString(2,"%"+PayMoney+"%");
        }else if (Name != null && Name != ""){
            String sql = "SELECT * FROM bill WHERE name LIKE ?";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+Name+"%");
        }else if (PayMoney != null && PayMoney != ""){
            String sql = "SELECT * FROM bill WHERE paymoney LIKE ?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+PayMoney+"%");
        }
        else {
            String sql = "SELECT * FROM bill;";
            ps = connection.prepareStatement(sql);
        }
        //5.执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        //6.遍历结果集，保存信息
        List<Bill> list = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int number = resultSet.getInt("number");
            double money = resultSet.getDouble("money");
            String paymoney = resultSet.getString("paymoney");
            String supname = resultSet.getString("supname");
            String notice = resultSet.getString("notice");
            String date = resultSet.getString("date");
            Bill bill = new Bill(id,name,number,money,paymoney,supname,notice,date);
            list.add(bill);
        }
        //7.关闭连接
        Tool.CloseAll(connection,ps,resultSet);
        return list;
    }

    /**
     * 添加商品信息的方法
     */
    public int InsertCheckDao(Bill bill) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        if (bill != null){
//            (name != null && name != "") && (money != null) && (supname != null && supname != "") && (paymoney != null && paymoney != "") && (time != null && time != "")
            //2.写SQL语句
            String sql = "INSERT INTO bill VALUES(null,?,?,?,?,?,?,?)";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,bill.getName());
            ps.setInt(2,bill.getNumber());
            ps.setDouble(3,bill.getMoney());
            ps.setString(4,bill.getPaymoney());
            ps.setString(5,bill.getSupname());
            ps.setString(6,bill.getNotice());
            ps.setString(7,bill.getDate());
        }
        //5.执行SQL语句
        int i = ps.executeUpdate();
        //6.关闭连接
        Tool.CloseAll(connection,ps,null);
        return i;
    }

    /**
     * 查询供应商信息的方法
     */
    public List<Supplier> SelectSupplierDao(String providerName, String providerDesc) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句（并且判断）
        PreparedStatement ps = null;
        if ((providerName != null && providerName != "") && (providerDesc != null && providerDesc != "")){
            String sql = "SELECT * FROM supplier WHERE supname LIKE ? and notice LIKE ?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+providerName+"%");
            ps.setString(2,"%"+providerDesc+"%");
        }else if (providerName != null && providerName != ""){
            String sql = "SELECT * FROM supplier WHERE supname LIKE ?";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+providerName+"%");
        }else if (providerDesc != null && providerDesc != ""){
            String sql = "SELECT * FROM supplier WHERE notice LIKE ?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+providerDesc+"%");
        }
        else {
            String sql = "SELECT * FROM supplier;";
            ps = connection.prepareStatement(sql);
        }
        //5.执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        //6.遍历结果集，保存信息
        List<Supplier> list = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String supname = resultSet.getString("supname");
            String notice = resultSet.getString("notice");
            String username = resultSet.getString("username");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            Supplier supplier = new Supplier(id,supname,notice,username,tel,address,email);
            list.add(supplier);
        }
        //7.关闭连接
        Tool.CloseAll(connection,ps,resultSet);
        return list;
    }

    /**
     * 添加供应商信息的方法
     */
    public int InsertSupplierDao(Supplier supplier) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        if (supplier != null){
            //2.写SQL语句
            String sql = "INSERT INTO supplier VALUES(NULL,?,?,?,?,?,?)";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,supplier.getSupname());
            ps.setString(2,supplier.getSupnotice());
            ps.setString(3,supplier.getName());
            ps.setLong(4,supplier.getSuptel());
            ps.setString(5,supplier.getSupaddress());
            ps.setString(6,supplier.getSupemail());
        }
        //5.执行SQL语句
        int i = ps.executeUpdate();
        //6.关闭连接
        Tool.CloseAll(connection,ps,null);
        return i;
    }

    /**
     * 查询用户信息的方法
     */
    public List<User> SelectUserDao(String username, PageBean pageBean) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        if (username != null && username != ""){
            //2.写SQL语句
            String sql = "SELECT * FROM users WHERE name LIKE ? limit ?,?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+username+"%");
            ps.setInt(2,pageBean.getSelectXiaBiao());
            ps.setInt(3,pageBean.getPageSize());
        }else {
            //2.写SQL语句
            String sql = "SELECT * FROM users limit ?,?;";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setInt(1,pageBean.getSelectXiaBiao());
            ps.setInt(2,pageBean.getPageSize());
        }
        //5.执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        //6.遍历结果集，保存信息
        List<User> list = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String role = resultSet.getString("role");
            User user = new User(id,name,sex,age,tel,address,role);
            list.add(user);
        }
        //7.关闭连接
        Tool.CloseAll(connection,ps,resultSet);
        return list;
    }

    /**
     * 添加用户信息的方法
     */
    public int InsertUserDao(User user) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        PreparedStatement ps = null;
        if (user != null){
            //2.写SQL语句
            String sql = "INSERT INTO users VALUES(null,?,?,?,?,?,?,?)";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setInt(3,user.getAge());
            ps.setLong(4,user.getTel());
            ps.setString(5,user.getAddress());
            ps.setString(6,user.getRole());
            ps.setString(7,user.getPwd());
        }
        //5.执行SQL语句
        int i = ps.executeUpdate();
        //6.关闭连接
        Tool.CloseAll(connection,ps,null);
        return i;
    }

    /**
     * 查询用户信息总记录的方法
     */
    public int SelectCountUserDao(String name) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        String sql = null;
        PreparedStatement ps = null;
        if (name != null && name != ""){
            //2.写SQL语句
            sql = "select count(*) as 总记录数 from users where name like ?";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
            //4.传参
            ps.setString(1,"%"+name+"%");
        }else {
            //2.写SQL语句
            sql = "select count(*) as 总记录数 from users";
            //3.创建SQL执行器
            ps = connection.prepareStatement(sql);
        }
        //5.执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        //6.遍历结果集，获得内容
        int total = 0;
        if (resultSet.next()){
            total = resultSet.getInt("总记录数");
        }
        //7.关闭连接
        Tool.CloseAll(connection,ps,resultSet);
        return total;
    }

    /**
     * 根据用户id查询用户信息的方法
     */
    public User SelectUserByIdDao(int id) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句
        String sql = "select * from users where id = ?";
        //3.创建SQL执行器
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.传参
        ps.setInt(1,id);
        //5.执行SQL语句
        ResultSet resultSet = ps.executeQuery();
        User user = null;
        //6.遍历结果集，获得内容
        while (resultSet.next()){
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            long tel = resultSet.getLong("tel");
            String address = resultSet.getString("address");
            String role = resultSet.getString("role");
            user = new User(id,name,sex,age,tel,address,role);
        }
        //7.关闭操作
        Tool.CloseAll(connection,ps,resultSet);
        return user;
    }

    /**
     * 修改用户信息的方法
     */
    public int UpdateUserDao(User user) throws SQLException {
        System.out.println("进入Dao了");
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句
        String sql = "UPDATE users SET name = ?,sex = ?,age = ?,tel = ?,address = ?,role = ? where id = ?";
        //3.创建SQL执行器
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.传参
        ps.setString(1,user.getName());
        ps.setString(2,user.getSex());
        ps.setInt(3,user.getAge());
        ps.setLong(4,user.getTel());
        ps.setString(5,user.getAddress());
        ps.setString(6,user.getRole());
        ps.setInt(7,user.getId());
        //5.执行SQL语句
        int i = ps.executeUpdate();
        //6.关闭操作
        Tool.CloseAll(connection,ps,null);
        return i;
    }

    /**
     * 删除用户的方法
     */
    public int DeleteUserDao(int id) throws SQLException {
        //1.获得连接
        Connection connection = Tool.getConnection();
        //2.写SQL语句
        String sql = "delete from users where id = ?";
        //3.创建SQL执行器
        PreparedStatement ps = connection.prepareStatement(sql);
        //4.传参
        ps.setInt(1,id);
        //5.执行SQL语句
        int i = ps.executeUpdate();
        //6.关闭操作
        Tool.CloseAll(connection,ps,null);
        return i;
    }
}
