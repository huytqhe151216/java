
/*
 Assignment 1 - Income Tax
 Class ID       : SE1607
 Student ID     : HE151216
 Student Name   : To Quang Huy
 Due Date       : 30 October 2021
 I declare that this assignment is my own work
 in accordance with FPT Policy.
 */
package incometax;

/**
 *
 * @author HUYTQ
 */
public class Node {

    TaxPayer info;
    Node next;

    public Node() {
    }

    public Node(TaxPayer x, Node p) {
        info = x;
        next = p;
    }

    public Node(TaxPayer x) {
        this(x, null);
    }
}
