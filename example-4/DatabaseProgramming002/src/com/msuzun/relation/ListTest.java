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
public class ListTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "msuzun";
        Connection connection = DriverManager.getConnection(url,user,password);
        
        //String sql = "select Employee.*, departmentName"
                    //+" from Employee inner join Departmet "
                    //+" on Employee.departmetId = Departmet.departmentId";
        String sql = "select * from employeeListview";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            long employeeId = resultSet.getLong("employeeId");
            String employeeName = resultSet.getString("employeeName");
            double monthlySales = resultSet.getDouble("monthlySalary");
            int departmentId = resultSet.getInt("departmetId");
            String departmentName = resultSet.getString("departmentName");
            System.out.printf("%10d %-20s %10f %10d %-20s \r\n",employeeId, employeeName, monthlySales,departmentId,departmentName);
        }
        
        connection.close();
    }
}
