/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.security.acl.Owner;
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

    void fvisit1(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.info.price >= 3 && p.info.price <= 5) {
            f.writeBytes(p.info + " ");
        }
    }

    void fvisit2(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.left.info.price < 7 && p.right.info.price < 7) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder1(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit1(p, f);
        preOrder1(p.left, f);
        preOrder1(p.right, f);
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    Node fvisit7(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.left != null & p.right != null && p.info.price == 7) {
            return p;
        }
        return null;
    }

    Node preOrder7(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }
        if (p != null && p.left != null & p.right != null && p.info.price == 7) {
            return p;
        }
        preOrder7(p.left, f);
        preOrder7(p.right, f);
        return p;
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

    Node breadth1(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
//            
            if (r != null && r.left != null && r.right != null && r.info.price < 7) {
                return r;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
        return null;
    }
    Node findNode=root;
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
//            fvisit(r, f);
            if (r != null && r.left != null && r.info.price < 7) {
                findNode=r;
                return;
            }
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
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        } else {
            Car car = new Car(xOwner, xPrice);
            Node node = new Node(car);
            if (isEmpty()) {
                root = node;
            } else {
                Node cu = root;
                Node f = null;// tim node f la cha cua node can add vao
                while (cu != null) {
                    if (cu.info.price == car.price) {
//                    System.out.println("Key: " + car.price + "already exist");
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

    Node RightRotate(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node c = p.left;
        Node temp = c.right;
        c.right = p;
        p.left = temp;
        return c;
    }

    void RightRotate(int key) {
        Node p = search(key);
        if (p == null || p.left == null) {
            return;
        }
        Node f = findFather(key);
        Node afterRotate = RightRotate(p);
        if (f == null) {// node can quay chi la root
            root = afterRotate;
        } else {
            if (f.info.price == key) {
                f.left = afterRotate;

            } else {
                f.right = afterRotate;
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

    void deleteByMergingLeft(int key) {
        Node p = search(key);
        if (p == null || p.left == null) {
            return;
        }
        Node f = findFather(key);
        //tim node ngoai cung cua con ben trai
        Node cu = p.left;
        while (cu.right != null) {
            cu = cu.right;
        }
        cu.right = p.right; // gan con ben phai cua node can xoa vao vao node ngoai cung ben phai cua con ben trai
        if (root.info.price == key) {//node can xoa la root
            root = root.left;
        } else { // dua con trai len lam cha
            if (f.left.info.price == key) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
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
//        preOrder(root, f);
//        postOrder(root, f);
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//        Node p = root;
//
//        if (p != null && p.info.price >= 3 && p.info.price <= 5) {
//            fvisit1(p, f);
//        }
//        preOrder1(p.left, f);
//        preOrder1(p.right, f);

//dung postoder de duyet toan bo cay va in ra gia tri trong khoang [-5,3]
//        Node p = root;
//        postOrder4(p.left, f);
//        postOrder4(p.right, f);
//        if (p != null && p.info.price >= -5 && p.info.price <= 3) {
//            f.writeBytes(p.info + " ");
//        }
//pre
//        Node p = root;
////        if (p != null && checkPrime(p.info.price)) {
////            f.writeBytes(p.info + " ");
////        }
//        fvisit5(p, f);
//        preOrder5(p.left, f);
//        preOrder5(p.right, f);
        //dung breath de duyet toan bo cay va in ra price la snt
        Node p = root;
        breadth6(p, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// dung preoder de duyet toan bo cay va in ra price co gia tri la snt
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
//        breadth(root, f);
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//        deleteByCopyLeft(breadth1(root, f).info.price);

        //dung pre oder de tim node dau tien co 2 con va price nho hon 7
        // detele by copy con trai node vua tim thay
        deleteByCopyLeft(preOrder7(root, f).info.price);
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
        RightRotate(breadth2(root, f).info.price);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    //dùng postoder de duyet toan bo cay va in ra gia tri nam trong khoang[3,-5]
    void postOrder4(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder4(p.left, f);
        postOrder4(p.right, f);
        fvisit4(p, f);
    }

    void fvisit4(Node p, RandomAccessFile f) throws Exception {
        if (p != null && p.info.price >= -5 && p.info.price <= 3) {
            f.writeBytes(p.info + " ");
        }
    }

    // dung preoder de duyet toan bo cay va in ra price co gia tri la snt
    void preOrder5(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit5(p, f);
        preOrder5(p.left, f);
        preOrder5(p.right, f);
    }

    void fvisit5(Node p, RandomAccessFile f) throws Exception {
        if (p != null && checkPrime(p.info.price)) {
            f.writeBytes(p.info + " ");
        }
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

    //    //dung breath de duyet toan bo cay va in ra price la snt
    void breadth6(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit6(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void fvisit6(Node p, RandomAccessFile f) throws Exception {
        if (p != null && checkPrime(p.info.price)) {
            f.writeBytes(p.info + " ");
        }
    }
}
