/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author MSUZUN
 */
public class DatabaseUtilitys {
    public static String url = "jdbc:mysql://localhost:3306/javaegitim";
    public static String user = "root";
    public static String password = "-";
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
       
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    
}
