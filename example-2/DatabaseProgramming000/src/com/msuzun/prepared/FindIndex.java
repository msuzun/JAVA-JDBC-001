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
public class FindIndex {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        
        String sql = "select * from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, 10);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            long productId = resultSet.getLong("productId");
            String productName = resultSet.getString("productName");
            double productSales = resultSet.getDouble("productSales");
            System.out.println("Ürün No : "+productId);
            System.out.println("Ürün Adı : "+productName);
            System.out.println("Satış Fiyatı : "+productSales);
        }
        else{
            System.out.println("Kayıt bulunamadı");
        }
        
        connection.close();
    }
}
