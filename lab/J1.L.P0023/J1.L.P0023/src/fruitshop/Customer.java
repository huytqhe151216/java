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

/**
 * This class contains information of customer.
 *
 * @author HuyTQ
 */
public class Customer {

    private String name;

    /**
     * no parameter constructor.
     */
    public Customer() {
    }

    /**
     * constructor with parameter:
     *
     * @param name
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Getter of Customer.
     *
     * @return string is customer name.
     */
    public String getCustomer() {
        return name;
    }
}
