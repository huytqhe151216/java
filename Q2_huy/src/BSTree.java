/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void fvisit4(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.right != null && checkPrime(p.info.price)) {
            findNode2 = p;
            return;
        }

    }

    void fvisit1(Node p, RandomAccessFile f) throws Exception {
        if (p != null && checkPrime(p.info.price)) {
            f.writeBytes(p.info + " ");
        }
    }

    Node fvisit2(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.left != null && p.right != null && checkPrime(p.info.price)) {
            return p;
        }
        return null;
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

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }
    Node findNode = root;

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p != null && p.left != null && p.right != null && checkPrime(p.info.price)) {
            findNode = p;
            return;
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);

    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder1(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder1(p.left, f);
        postOrder1(p.right, f);
        fvisit1(p, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void postOrder4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder4(p.left, f);
        postOrder4(p.right, f);
        if (p != null && p.right != null && checkPrime(p.info.price)) {
            findNode2 = p;
            return;
        }

    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.endsWith('X' + "") || xPrice > 50 || xPrice < 0) {
            return;
        } else {
            Car car = new Car(xOwner, xPrice);
            Node node = new Node(car);
            if (isEmpty()) {
                root = node;
            } else {
                Node cu = root;
                Node f = null;
                while (cu != null) {
                    if (cu.info.price == car.price) {
                        return;
                    }
                    f = cu;
                    if (cu.info.price < car.price) {
                        cu = cu.right;
                    } else {
                        cu = cu.left;
                    }
                }
                if (f.info.price < car.price) {
                    f.right = node;
                } else {
                    f.left = node;
                }
            }
        }

    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
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
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = root;
        postOrder1(p.left, f);
        postOrder1(p.right, f);
        fvisit1(p, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void deleteByCopyLeft(int key) {
        Node p = search(key);
        if (p == null || p.left == null) {
            return;
        }
        if (p.left.right == null) {
            p.info = p.left.info;
            p.left = p.left.left;
        } else {
            Node f = p.left;
            Node cu = p.left.right;
            while (cu.right != null) {
                f = cu;
                cu = cu.right;
            }
            p.info = cu.info;
            f.right = cu.left;
        }
    }

    public Node search(int key) {
        Node cur = root;
        Node f = null;
        if (cur == null) {
            return null;
        }
        while (cur != null) {
            if (cur.info.price == key) {
                return cur;
            } else {
                f = cur;
                cur = (cur.info.price < key) ? cur.right : cur.left;
            }
        }
        return (f.info.price != key) ? null : f;
    }
// f.writeBytes(" k = " + k + "\r\n");
//=============================================================

    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = root;
        preOrder2(p, f);
        deleteByCopyLeft(findNode.info.price);
        //------------------------------------------------------------------------------------
        preOrder(p, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node LeftRotate(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node c = p.right;
        Node temp = c.left;
        c.left = p;
        p.right = temp;
        return c;
    }

    void LeftRotate(int key) {
        Node p = search(key);
        if (p == null || p.right == null) {
            return;
        }
        Node f = findFather(key);
        Node afterRotate = LeftRotate(p);
        if (f == null) {// node can quay chi la root
            root = afterRotate;
        } else {
            if (f.info.price == key) {
                f.right = afterRotate;

            } else {
                f.left = afterRotate;
            }
        }
    }

    Node findFather(int key) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.price == key) {
                break;
            }
            f = p;
            if (key < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return f;

    }
    Node findNode2 = root;

    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = root;
        postOrder4(p, f);
        LeftRotate(findNode2.info.price);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
