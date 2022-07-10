
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

import dal.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class Product {
    private  int id;
    private String name;
    private String depscription;
    private int price;
    private String quantityPerUnit;
    private int unitInStock;
    private Category categoryId;

    public Product() {
    }

    public Product(int id, String name, String depscription, int price, String quantityPerUnit, int unitInStock, Category categoryId) {
        this.id = id;
        this.name = name;
        this.depscription = depscription;
        this.price = price;
        this.quantityPerUnit = quantityPerUnit;
        this.unitInStock = unitInStock;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepscription() {
        return depscription;
    }

    public void setDepscription(String depscription) {
        this.depscription = depscription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getImg(){
        ProductDAO productDAO =new ProductDAO();
        return productDAO.getProductImgById(id).get(0);
        
    }

   

    
    
}
