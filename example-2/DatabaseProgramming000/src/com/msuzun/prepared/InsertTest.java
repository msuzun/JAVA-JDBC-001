/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author MSUZUN
 */
public class InsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        
       String sql = "insert into Product(productName,productSales) values(?,?)";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, "Dizüstü bilgisayar");
        statement.setDouble(2, 1450);
       int affected = statement.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected);
        connection.close();
    }
}
