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
public class myDoubleList {

    Node head, tail;

    public myDoubleList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null && tail == null;
    }

    //them dau
    void addFirst(Car c) {
        Node node = new Node(c);
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    //them dau 1
    void addFirst(String name, int price) {
        Node node = new Node(new Car(name, price));
        if (isEmpty()) {
            head = tail = node;
        } else {
            head.pre = node;
            node.next = head;
            head = node;
        }
    }

    //them cuoi
    void addLast(String name, int price) {
        Node node = new Node(new Car(name, price));
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    //them cuoi1
    void addLast(Car c) {
        Node node = new Node(c);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    void display() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.info + ". ");
            cur = cur.next;
        }
        System.out.println("");
    }

    void reDisplay() {
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.info + ". ");
            cur = cur.pre;
        }
        System.out.println("");
    }

    int getRange() {
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            pos++;
            cur = cur.next;
        }
        return pos;
    }

    Node findFather(int index) {
        int pos = 0;
        if (index <= 0) {
            return null;
        }
        Node cur = head;
        while (cur.next != null) {
            if (index - 1 == pos) {
                return cur;
            }
            cur = cur.next;
            pos++;

        }
        if (index - 1 == pos) {
            return tail;
        }

        return null;
    }

    void addIndex(Car c, int index) {
        // cur nam o vi tri cha cua node can add
        Node node = new Node(c);
        Node cur = findFather(index);
        int pos = 0;
        if (index < 0 || index >= getRange()) {
            return;
        } else {
            if (index == 0) {
                addFirst(c);
            } else if (index == getRange() - 1) {
                addLast(c);
            } else {
                node.next = cur.next;
                cur.next.pre = node;
                node.pre = cur;
                cur.next = node;
            }
        }

    }

    void addIndex(String name, int price, int index) {
        // 1. Cur nam o vi tri cha cua node can add
        // Node.next = Cur.next
        // cur.next.pre = node
        // node.pre = cur
        // cur.next = node

        // 2. Cur nam o vi tri can add
        // node.pre = cur.pre
        // cur.pre.next = node
        // node.next = cur
        // cur.pre = node
    }

    Car deleteFirst() {
        Car c;
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            c = head.info;
            head = tail = null;
            return c;
        }
        c = head.info;
        head.next.pre = null;
        head = head.next;
        return c;
    }

    Car deleteLast() {
        Car c;
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            c = head.info;
            head = tail = null;
            return c;
        }
        c = tail.info;
        tail.pre.next = null;
        tail = tail.pre;
        return null;
    }

    public static void main(String[] args) {
        myDoubleList my = new myDoubleList();
        Car c = new Car("huy", 0);
        Car d = new Car("huy1", 1);
        Car e = new Car("huy2", 2);
        Car f = new Car("Carf", 3);

        my.addFirst(c);
        my.addFirst(d);
        my.addFirst(e);
        my.display();
        my.addIndex(f, 3);
        my.display();
    }
}
