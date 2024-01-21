/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.inventory.test;

import com.msuzun.inventory.entity.Product;
import com.msuzun.inventory.manager.ProductManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSUZUN
 */
public class ProductConditionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ProductManager manager = new ProductManager();
        double sales = 500;
        List<Product> productList = manager.listBySalesPriceGreater(sales);
        for(Product product : productList){
             System.out.printf("%10d %-20s %10f \r\n",product.getProductId(), product.getProductName(), product.getProductPrice());
        }
    }
}
