/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class AggregateGroupByTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
          Class.forName("com.mysql.cj.jdbc.Driver"); // database kütüphanesi bağlantısı
        String url = "jdbc:mysql://localhost:3306/javaegitim";
        String user = "root";
        String password = "-";
        Connection connection = DriverManager.getConnection(url,user,password);
        //String sql =  "select Employee.*, departmentName"
                    //+" from Employee inner join Departmet "
                    //+" on Employee.departmetId = Departmet.departmentId"
                    //+" where employeeId = ?";
        String sql = "select departmetId,count(*) as countOfEmployee from employeeListview group By departmetId";
        //String sql = "select sum(monthlySalary) as sumOfMonthlySalary from employeeListview";      
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           
            int result = resultSet.getInt("departmetId");
            int departmentId = resultSet.getInt("countOfEmployee");
            System.out.println("Bölüm No :  "+departmentId + "Sayı : "+ result + " ");
        }
       
    }
}
