
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Product {
   private int id;
   private String productName;
   private double unitPrice;
   private Category category;
   private int unitInStock;

    public Product() {
    }

    public Product(int id, String productName, double unitPrice, Category category, int unitInStock) {
        this.id = id;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.category = category;
        this.unitInStock = unitInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }
    
}
