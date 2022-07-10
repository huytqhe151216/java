
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
public class Node {
    Car info;
    Node left, right;

    public Node() {
    }

    public Node(Car c) {
        info=c;
        left =right=null;
    }
    public Node(String name, int price){
        info = new Car(name, price);
        left = right = null ;
    }
}
