/*
 * Copyright(C) 2021, To Quang Huy
 * J1.L.P0023
 * Fruit Shop
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-11-01       1.0                HuyTQ            First Implement
 */
package fruitshop;

import java.util.ArrayList;

/**
 * This class contain an array list contain chosen fruit and buyer.
 *
 * @author HuyTQ
 */
public class Order {

    private Customer customer;  
    private ArrayList<Fruit> fruits; 

    /**
     * no parameter constructor
     */
    public Order() {
    }

    /**
     * Constructs with parameters:
     *
     * @param customer 
     * @param fruits 
     */
    public Order(Customer customer, ArrayList<Fruit> fruits) {
        this.customer = customer;
        this.fruits = fruits;
    }

    /**
     * Getter of Customer
     *
     * @return customer objects
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Getter of Fruit.
     *
     * @return list of fruit
     */
    public ArrayList<Fruit> getFruits() {
        return fruits;
    }
}
