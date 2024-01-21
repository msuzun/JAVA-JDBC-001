/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
/**
 *
 * @author MSUZUN
 */
public class CallableTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        int employeeId = 3;
        double increasePercentage = 25;
        CallableStatement statement = connection.prepareCall("{call EmployeeSalaryIncrease(?,?)}");
        statement.setInt(1,employeeId);
        statement.setDouble(2,increasePercentage);
        statement.execute();
    }
}
