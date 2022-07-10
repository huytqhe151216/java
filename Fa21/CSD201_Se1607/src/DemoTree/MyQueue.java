
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
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
public class MyQueue {
    NodeQ head, tail;
    
    public MyQueue(){
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void EnQueue(Node p){
        NodeQ node = new NodeQ(p);
        if(isEmpty()){head=tail=node;}
        else{
            tail.next = node;
            tail = node;
        }
    }
    public Node DeQueue(){
        if(isEmpty()) return null;
        Node value = head.value;
        head = head.next;
        return value;
    }
}

