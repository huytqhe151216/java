
/*
 * Copyright(C) 2005, Morses Club of London Scottish Bank.
 * T.NET:
 *  Transport and Information Network
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package DemoTree;

/**
 *
 * @author ADMIN
 */
public class Car {
    String name;
    int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "("+name+", "+price+")";
    }
    
}
