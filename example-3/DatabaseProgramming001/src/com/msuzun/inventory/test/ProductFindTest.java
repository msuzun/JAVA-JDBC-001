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
public class ProductFindTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
        ProductManager manager = new ProductManager();
        long productId = 28;
        Product product = manager.find(productId);
        if (product != null) {
              System.out.println(product.getProductId() + " " + product.getProductName()
                +" " +product.getProductPrice());
        }
        else{
            System.out.println("Ürün bulunamadı"+ productId);
        }
      
    }
}
