/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.msuzun.inventory.test;

import com.msuzun.inventory.entity.Product;
import com.msuzun.inventory.manager.ProductManager;
import java.sql.SQLException;

/**
 *
 * @author MSUZUN
 */
public class ProductDeleteTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
        ProductManager manager = new ProductManager();
        long productId = 1;
        boolean deleted = manager.delete(productId);
        System.out.println("Silindi mi? "+deleted);
      
    }
}
