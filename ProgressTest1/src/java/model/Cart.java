
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package model;

import dal.ProductDAO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cart {

    private Customers customer;
    private HashMap<Products, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public HashMap<Products, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Products, Integer> items) {
        this.items = items;
    }

    public Cart(Customers customer, HashMap<Products, Integer> items) {
        this.customer = customer;
        this.items = items;
    }

    public boolean contain(Products p) {
        return items.containsKey(p);
    }

    public int size() {
        return items.size();
    }

    public void addItem(Products products, int num) {
        if (items.containsKey(products)) {
            items.put(products, getQuantity(products) + num);
        } else {
            items.put(products, 1);
        }
    }
    
    public int getQuantity(Products p) {
        return items.get(p);
    }

    public void deleteProduct(int pid) {
        ProductDAO dao = new ProductDAO();
        items.remove(dao.getProductById(pid));
    }
    public double totalPrice(){
        double  total=0;
        for (Map.Entry<Products, Integer> entry : items.entrySet()) {
            Products key = entry.getKey();
            Integer value = entry.getValue();
            total+=Double.parseDouble(key.getUnitPrice())*value;
        }
        if (items.isEmpty()) {
            return 0;
        }
        return total;
    }
}
