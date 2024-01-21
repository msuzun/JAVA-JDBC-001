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
public class ProductUpdateTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
        ProductManager manager = new ProductManager();
        Product product = new Product(20, "Masaüstü bilgisayar", 80000);
        boolean updated = manager.update(product);
        System.out.println("Güncellendi mi? "+updated);
    }
}
