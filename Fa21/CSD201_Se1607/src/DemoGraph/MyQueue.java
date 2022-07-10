
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package DemoGraph;

/**
 *
 * @author ADMIN
 */
public class MyQueue {
    Node head, tail;

    public MyQueue() {
        head=tail=null;
    }
    boolean isEmpty(){
        return head==null;
    }
    void EnQueue(int x){
        Node node= new Node(x);
        if (isEmpty()) {
            head=tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
    }
    int DeQueue(){
        if (isEmpty()) {
            return -1;
        }
        int value=head.info;
        head=head.next;
        return value;
        
    }
    
}
class Node{
    int info;
    Node next;

    public Node() {
    }

    public Node(int info) {
        this.info = info;
        this.next = null;
    }
    
}
