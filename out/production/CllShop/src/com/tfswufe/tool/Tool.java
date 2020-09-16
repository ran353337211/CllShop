package com.tfswufe.tool;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Tool {
    /**
     * 获得连接的方法
     */
    public static Connection getConnection(){
        //1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        DriverManager.registerDriver(new Driver());
        //2.配置连接信息
        Properties properties = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream("F:\\IdeaProjects\\system\\CllShop\\jdbc.properties");
            properties.load(file);
        } catch (Exception e) {
            System.out.println("配置文件找不到");
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //3.获得连接
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接的方法
     */
    public static void CloseAll(Connection connection, PreparedStatement ps, ResultSet resultSet){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("connection关闭失败");
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("ps关闭失败");
            }
        }
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("resultSet关闭失败");
            }
        }
    }
}
