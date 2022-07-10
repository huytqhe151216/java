/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addLast(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.endsWith('A' + "") || xPrice > 50 || xPrice < 0) {
            return;
        } else {
            Car newCar = new Car(xOwner, xPrice);
            Node node = new Node(newCar);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    boolean checkPrime(int a) {
        if (a < 2) {
            return false;
        }
        if (a == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    void addFirst(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addLast(Car value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void addIndex(Car value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head;
            int pos = 0;
            while (cur != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == null)// index lon hon size cua list
            {
                return;
            }
            if (cur.next == null) {
                addLast(value);
            } else {
                Node node = new Node(value);
                node.next = cur.next;
                cur.next = node;
            }
        }

    }
//==================================================================

    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
       
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//         int index = 0;
//         Node cur= head;
//        Car x = new Car("X", 1);
//        while (cur != null) {
//            if (checkPrime(cur.info.price)) {
//                break;
//            }
//            index++;
//            cur = cur.next;
//        }
//        addIndex(x, index+1);
            Node cur=head;
            Car x=new Car("X", 1);
            int pos=0;
            while (cur!=null) {
                if (checkPrime(cur.info.price)) {
                    break;
                } else {
                    cur=cur.next;
                    pos++;
                }
        }
            addIndex(x, pos+1);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    boolean squareNumber(int x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }
void deleteIndex(int index) {
        if (index < 0) {

        }
        if (index == 0) {
            deleteFirst();
        } else {
            Node cur = head;
            int pos = 0;
            while (cur.next != null) {
                if (index - 1 == pos) {
                    break;
                }
                pos++;
                cur = cur.next;
            }
            if (cur == tail) {

            } else if (cur.next == tail) {
                deleteLast();
            } else {
                cur.next = cur.next.next;
            }
        }
    }
void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }
void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }
            cur.next = null;
            tail = cur;
        }
    }
    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node cur = head;
        int pos=0;
        while (cur!=null) {
            if (squareNumber(cur.info.price)) {
                break;
            } else {
                cur=cur.next;
                pos++;
            }
        }
        deleteIndex(pos);
      
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
