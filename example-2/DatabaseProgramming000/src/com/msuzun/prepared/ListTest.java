/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class ListTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        
        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            double productSales = resultSet.getDouble("productSales");
            System.out.printf("%10d %-20s %10f \r\n",productId, productName, productSales);
        }
        
        connection.close();
    }
}
