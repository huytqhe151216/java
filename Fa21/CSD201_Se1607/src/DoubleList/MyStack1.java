/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleList;

/**
 *
 * @author ADMIN
 */
public class MyStack1 {
    Node head, tail;

    public MyStack1() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }
    
    void push(Car c) {
        Node node = new Node(c);
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }
    Car pop() {
        Car c;
        if (isEmpty()) {
            return null;
        }
        if (head == tail){
            c = head.info;
            head = tail = null;
            return c;
        }
        c = head.info;
        head.next.pre = null;
        head = head.next;
        return c; 
    }
    void reDisplay() {
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.info + ". ");
            cur = cur.pre;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        MyStack1 ms = new MyStack1();
        Car c = new Car("Toyota", 120000);
        Car d = new Car("Honda", 100500);
        Car e = new Car("Huyndai", 245000);
        Car f = new Car("Ferrari", 1245000);
        Car g = new Car("Mercedes", 645000);
        ms.push(c);
        ms.push(d);
        ms.push(e);

        System.out.println("push");
        ms.reDisplay();
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println("pop");
        ms.reDisplay();
    }
}

