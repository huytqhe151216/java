
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

import dal.CustomerDAO;
import dal.OrderDetailDAO;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Order {
    private  int id;
    private int customerId;
    
    public Order(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    
    
    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public boolean getOrderStatus(){
        OrderStatus orderStatus = new OrderStatus();
        return orderStatus.isStatus();
    }
    public Customer getCustomerById(){
        CustomerDAO  customerDAO = new CustomerDAO();
        return customerDAO.getCustomer(customerId);
    }
    public ArrayList<OrderDetail> viewOrderDetail(){
    
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    return orderDetailDAO.viewOrderDetail(id);
}
}
