/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class TransactionTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);

        connection.setAutoCommit(false);

        String sql = "insert into Product(productName,productSales) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "Masaüstü bilgisayar");
        statement.setDouble(2, 2000);
        int affected1 = statement.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected1);

        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setString(1, "Dizüstü bilgisayar");
        statement2.setDouble(2, 5000);
        int affected2 = statement2.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected2);
        int x = 3;
        if (x == 3) {
           connection.rollback();
        }
          
        PreparedStatement statement3 = connection.prepareStatement(sql);
        statement3.setString(1, "Tablet");
        statement3.setDouble(2, 800);
        int affected3 = statement3.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected3);

        connection.commit();

        connection.close();
    }
}
