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

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
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
        return p;
    }
    void fvisit3(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.right!=null&& checkPrime(p.info.price)) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    Node preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }
        if (p != null && p.left != null && p.right != null && checkPrime(p.info.price)) {
            return p;
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
        return null;
    }

    void deleteByCopyLeft(int key) {
        Node p = search(key);
        if (p == null || p.left == null) {
            return;
        }
        if (p.left.right == null) {//node ngoài cùng bên phải của con trái 
            // trùng với node con trái của node cần xóa
            p.info = p.left.info;
            p.left = p.left.left;
        } else {
            Node f = p.left;
            Node cu = p.left.right;
            while (cu.right != null) {
                f = cu;//cha cua node ngoai cung ben phai cua con trai
                cu = cu.right;
            }
            p.info = cu.info;
            f.right = cu.left;
        }
    }

    Node search(int key) {
        //tim va tra ve node co key = key nhap vao tu ban phim
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

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void postOrder1(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder1(p.left, f);
        postOrder1(p.right, f);
        fvisit1(p, f);
    }
    void postOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder3(p.left, f);
        postOrder3(p.right, f);
        fvisit3(p, f);
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
        if (xOwner.charAt(xOwner.length() - 1) == 'X' || xPrice > 50 || xPrice < 0) {
            return;
        } else {
            Car c = new Car(xOwner, xPrice);
            Node node = new Node(c);
            if (isEmpty()) {
                root = node;
            } else {
                Node current = root;
                Node father = null; //Tim node father la cha cua node can add vao
                while (current != null) {
                    if (current.info.price == c.price) {
                        //System.out.println("Key : " + c.price + " da ton tai trong Tree");
                        return;
                    }
                    father = current;
                    current = current.info.price < c.price ? current.right : current.left;
                }
                if (father.info.price < c.price) {
                    father.right = node;
                } else {
                    father.left = node;
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
        postOrder1(p, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
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
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = root;
        deleteByCopyLeft(preOrder2(p, f).info.price);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
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

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
