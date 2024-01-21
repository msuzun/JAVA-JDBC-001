/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class FilterTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "msuzun";
        Connection connection = DriverManager.getConnection(url,user,password);
        
        String sql = "select employeeId,employeeName,monthlySalary,departmentName "
                    +" from Employee inner join Departmet "
                    +" on Employee.departmetId = Departmet.departmentId"
                    +" where departmetId = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, 2);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            long employeeId = resultSet.getLong("employeeId");
            String employeeName = resultSet.getString("employeeName");
            double monthlySales = resultSet.getDouble("monthlySalary");
            
            String departmentName = resultSet.getString("departmentName");
            System.out.printf("%10d %-20s %10f  %-20s \r\n",employeeId, employeeName, monthlySales,departmentName);
        }
        
        connection.close();
    }
}
