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
public class FindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "msuzun";
        Connection connection = DriverManager.getConnection(url,user,password);
        int employeeId =5;
        //String sql =  "select Employee.*, departmentName"
                    //+" from Employee inner join Departmet "
                    //+" on Employee.departmetId = Departmet.departmentId"
                    //+" where employeeId = ?";
        String sql = "select * from employeeListview where employeeId = ?";            
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, employeeId);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
              
            String employeeName = resultSet.getString("employeeName");
            double monthlySales = resultSet.getDouble("monthlySalary");
           
            String departmentName = resultSet.getString("departmentName");
            System.out.println("Çalışan Id : "+employeeId);
            System.out.println("Çalışan Adı : "+employeeName);
            System.out.println("Çalışan Maaşı : "+monthlySales);
            System.out.println("Çalışan Departmanı : "+departmentName);
        }
        else{
            System.out.println("Kayıt bulunamadı");
        }
        
        connection.close();
    }
}
