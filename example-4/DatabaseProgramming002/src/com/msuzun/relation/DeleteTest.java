/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class DeleteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "msuzun";
        Connection connection = DriverManager.getConnection(url,user,password);
        
       String sql = "delete from Departmet where departmentId=?";
       PreparedStatement statement = connection.prepareStatement(sql);
      
        statement.setLong(1, 2);
       int affected = statement.executeUpdate();
        System.out.println("Etkilenen satır sayısı" + affected);
        connection.close();
    }
 
}
