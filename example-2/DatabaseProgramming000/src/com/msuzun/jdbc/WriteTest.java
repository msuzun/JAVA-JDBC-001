/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author MSUZUN
 */
public class WriteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "Ferah!1962m";
        Connection connection = DriverManager.getConnection(url,user,password);
        
       String sql = "insert into Product(productName,productSales) values('Bulaşık makinası',350)";
       Statement statement = connection.createStatement();
       int affected = statement.executeUpdate(sql);
        System.out.println("Etkilenen satır sayısı" + affected);
        connection.close();
    }
}
