
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
public class OrderDetail {
    private Order order;
    private int pid;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Order order, int pid, int quantity) {
        this.order = order;
        this.pid = pid;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getproductName(){
        ProductDAO ProductDAO = new ProductDAO();
        return ProductDAO.getProductById(pid).getName();
    }
    
}
