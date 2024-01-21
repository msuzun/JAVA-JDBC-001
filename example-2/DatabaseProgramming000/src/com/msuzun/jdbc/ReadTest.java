/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author MSUZUN
 */
public class ReadTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "Ferah!1962m";
        Connection connection = DriverManager.getConnection(url,user,password);
        
       String sql = "select * from Product";
       Statement statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            double productSales = resultSet.getDouble("productSales");
            System.out.println(productId + " "+ productName + " "+ productSales);
        }
        connection.close();
    }
}
