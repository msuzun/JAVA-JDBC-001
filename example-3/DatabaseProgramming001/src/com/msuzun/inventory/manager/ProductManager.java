/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.inventory.manager;


import com.msuzun.inventory.entity.Product;
import com.msuzun.library.database.DatabaseUtilitys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSUZUN
 */
public class ProductManager {
    public boolean insert(Product product) throws ClassNotFoundException, SQLException{
         
        Connection connection = DatabaseUtilitys.getConnection();
        
       String sql = "insert into Product(productName,productSales) values(?,?)";
       PreparedStatement statement = connection.prepareStatement(sql);
        
        
       statement.setString(1, product.getProductName());
       statement.setDouble(2, product.getProductPrice());
         
       int affected = statement.executeUpdate();
       
        connection.close();
        return affected == 1 ? true:false;
    }
    
    public boolean update(Product product) throws ClassNotFoundException, SQLException{
         
        Connection connection = DatabaseUtilitys.getConnection();
        
       String sql = "update Product set  productName =?, productSales =? where productId =?";
       PreparedStatement statement = connection.prepareStatement(sql);
       statement.setString(1, product.getProductName());
       statement.setDouble(2, product.getProductPrice());
       statement.setLong(3, product.getProductId());
       int affected = statement.executeUpdate();
       
        connection.close();
        return affected == 1 ? true:false;
    }
    
    public Product find(long productId) throws ClassNotFoundException, SQLException{
        Product product = null;
        Connection connection = DatabaseUtilitys.getConnection();
        String sql = "select * from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            product = new Product();
            product.setProductId(resultSet.getLong("productId"));
            product.setProductName(resultSet.getString("productName"));
            product.setProductPrice(resultSet.getDouble("productSales"));
        }
        connection.close();
        return product;
    }
    public boolean delete(long productId) throws ClassNotFoundException, SQLException{
       Connection connection = DatabaseUtilitys.getConnection();
       String sql = "delete from Product where productId=?";
       PreparedStatement statement = connection.prepareStatement(sql);
      
       statement.setLong(1, productId);
       int affected = statement.executeUpdate();
       connection.close();
       return affected == 1 ? true:false;
    }
    public List<Product> list() throws ClassNotFoundException, SQLException{
        Connection connection = DatabaseUtilitys.getConnection();
        List<Product> productList = new ArrayList<Product>();
        
        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           //Product product = new Product(resultSet.getLong("productId"), resultSet.getString("productName"), resultSet.getDouble("productSales"));
           Product product = new Product();
           product.setProductId(resultSet.getLong("productId"));
           product.setProductName(resultSet.getString("productName"));
           product.setProductPrice(resultSet.getDouble("productSales"));
           productList.add(product);
        }
        
        return productList;
    }
    
    public List<Product> listBySalesPriceGreater(double salesPrice) throws ClassNotFoundException, SQLException{
        Connection connection = DatabaseUtilitys.getConnection();
        List<Product> productList = new ArrayList<Product>();
        
        String sql = "select * from Product where productSales>=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, salesPrice);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           //Product product = new Product(resultSet.getLong("productId"), resultSet.getString("productName"), resultSet.getDouble("productSales"));
           Product product = new Product();
           product.setProductId(resultSet.getLong("productId"));
           product.setProductName(resultSet.getString("productName"));
           product.setProductPrice(resultSet.getDouble("productSales"));
           productList.add(product);
        }
        
        return productList;
    }
    
     public List<Product> listByProductNameLike(String productNamePattern) throws ClassNotFoundException, SQLException{
        Connection connection = DatabaseUtilitys.getConnection();
        List<Product> productList = new ArrayList<Product>();
        
        String sql = "select * from Product where productName like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, productNamePattern);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           //Product product = new Product(resultSet.getLong("productId"), resultSet.getString("productName"), resultSet.getDouble("productSales"));
           Product product = new Product();
           product.setProductId(resultSet.getLong("productId"));
           product.setProductName(resultSet.getString("productName"));
           product.setProductPrice(resultSet.getDouble("productSales"));
           productList.add(product);
        }
        
        return productList;
    }
     public List<Product> listByFilter(String productNamePattern,double salesPrice) throws ClassNotFoundException, SQLException{
        Connection connection = DatabaseUtilitys.getConnection();
        List<Product> productList = new ArrayList<Product>();
        
        String sql = "select * from Product where productName like ? or productSales>=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, productNamePattern);
        statement.setDouble(2, salesPrice);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
           //Product product = new Product(resultSet.getLong("productId"), resultSet.getString("productName"), resultSet.getDouble("productSales"));
           Product product = new Product();
           product.setProductId(resultSet.getLong("productId"));
           product.setProductName(resultSet.getString("productName"));
           product.setProductPrice(resultSet.getDouble("productSales"));
           productList.add(product);
        }
        
        return productList;
    }
}
