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
public class FunctionTest {
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
        //String sql = "select departmetId,count(*) as countOfEmployee from employeeListview group By departmetId";
        String sql = "select *, concat('EMP-',departmetId, '-', substring(employeeName,1,3))"
                     + " as employeeCode from employee";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           
            String employeeName= resultSet.getString("employeeName");
            String employeeCode = resultSet.getString("employeeCode");
            System.out.println("Bölüm Adı :  "+employeeName + " Max Salary : "+ employeeCode + " ");
        }
    }
}
