
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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cart {
    private  Customer customer;
    private HashMap<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<Product, Integer> items) {
        this.items = items;
    }

    public Cart(Customer customer, HashMap<Product, Integer> items) {
        this.customer = customer;
        this.items = items;
    }
    public boolean contain(Product p) {
        return items.containsKey(p);
    }
    public int size() {
        return items.size();
    }
    public void addItem(Product products, int num) {
        if (items.containsKey(products)) {
            if (getQuantity(products)<products.getUnitInStock()) {
                items.put(products, getQuantity(products) + num);
            }else if(num==-1){
                items.put(products, getQuantity(products) + num);
            }
            
        } else {
            items.put(products, 1);
        }
    }
     public int getQuantity(Product p) {
        return items.get(p);
    }
     public void deleteProduct(int pid) {
        ProductDAO dao = new ProductDAO();
        items.remove(dao.getProductById(pid));
    }
     public int totalPrice(){
        int  total=0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product key = entry.getKey();
            Integer value = entry.getValue();
            total+=key.getPrice()*value;
        }
        if (items.isEmpty()) {
            return 0;
        }
        return total;
    }
}
