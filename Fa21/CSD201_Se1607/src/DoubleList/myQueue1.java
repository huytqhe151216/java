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
public class myQueue1 {
     Node head, tail;

    public myQueue1() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }
    void enQueue(Car c) {
    //them cuoi
        Node node = new Node(c);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }
    void deQueue() {
    //Xoa dau tien
        Car c;
        if (isEmpty()) {
            
        }
        if (head == tail){
            c = head.info;
            head = tail = null;
            
        }
        c = head.info;
        head.next.pre = null;
        head = head.next;
        
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
        myQueue1 mq= new myQueue1();
        Car c = new Car("Toyota", 120000);
        Car d = new Car("Honda", 100500);
        Car e = new Car("Huyndai", 245000);
        mq.enQueue(c);
        mq.enQueue(d);
        mq.enQueue(e);
    }
}
