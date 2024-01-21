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
public class ProductInsertTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Product product = new Product(0, "Eğitim Seti", 50000);
        ProductManager manager = new ProductManager();
        boolean inserted = manager.insert(product);
        System.out.println("Eklendi mi? "+inserted);
    }
}
