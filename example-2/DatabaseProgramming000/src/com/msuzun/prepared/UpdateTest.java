/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class UpdateTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
           Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        
       String sql = "update Product set  productName =?, productSales =? where productId =?";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, "Akıllı telefon");
        statement.setDouble(2, 1750);
         statement.setLong(3, 5);
       int affected = statement.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected);
        connection.close();
    }
}
