
/*
 * Copyright(C) 2005, Morses Club of London Scottish Bank.
 * T.NET:
 *  Transport and Information Network
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
public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    void insert(Car c) {
        Node node = new Node(c);
        if (isEmpty()) {
            root = node;
        } else {
            Node cu = root;
            Node f = null;// tim node f la cha cua node can add vao
            while (cu != null) {
                if (cu.info.price == c.price) {
                    System.out.println("Key: " + c.price + "already exist");
                    return;
                }
                f = cu;
                if (cu.info.price < c.price) {
                    cu = cu.right;
                } else {
                    cu = cu.left;
                }
            }
            if (f.info.price < c.price) {
                f.right = node;
            } else {
                f.left = node;
            }
        }
    }

    void insert(String name, int price) {
        Car c = new Car(name, price);
        Node node = new Node(c);
        if (isEmpty()) {
            root = node;
        } else {
            Node current = root;
            Node father = null; //Tim node father la cha cua node can add vao
            while (current != null) {
                if (current.info.price == c.price) {
                    System.out.println("Key : " + c.price + " da ton tai trong Tree");
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

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + ", ");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void postOrder() {
        postOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void inOrder() {
        inOrder(root);
    }

    public Node findFather(int key) {
    if (isEmpty()|| key== root.info.price) return null;
    Node f = null;
    Node cu=root;
    while (cu!= null){
        if (cu.info.price==key) {
            return f;
        }
            f=cu;
            cu=cu.info.price<key?cu.right:cu.left;
    }
    return null;
    
    
    }
    public void deleteByCopy(int x) 
    {Node p = search(root, x);
     if(p==null) {System.out.println("Key "+x+" does not exists, deletion failed"); return;}
     //find f is father of p
     Node f = null, q = root;
     while(q!=p) {f=q; 
      if(q.info.price>p.info.price) q=q.left;
      else q=q.right;}
      //1.p has no child
      if(p.left==null&&p.right==null) {
       if(f==null) root=null;
       else if(f.left==p) f.left=null;
       else f.right = null;
      }
      //2.p has left child only
      else if(p.left!=null&&p.right==null) {
       if(f==null) root=p.left;
       else if(f.left==p) f.left=p.left;
       else f.right=p.left;
      }
      //3.p has right child only
      else if(p.left==null&&p.right!=null) {
       if(f==null) root=p.right;
       else if(f.left==p) f.left=p.right;
       else f.right=p.right;
      }
      //4.p has both child
      else if(p.left!=null&&p.right!=null) {
       //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
       //cua con trai cua p
       q = p.left;f = null;
       while(q.right != null) {f=q;q=q.right;}
       p.info = q.info;
       //delete q
       if(f==null) p.left=q.left;
       else f.right=q.left;
      }
    }
    Node search(Node p, int key) {
        if (p.info.price == key) {
            return p;
        }
        return p.info.price < key ? search(p.right, key) : search(p.left, key);
    }
        void deleteByCopyingLeftVietanh(int price) {
        Node p = search(root, price);
        if (p.left == null && p.right == null) {
            Node findFather = findFather(p.info.price);
            if (findFather.left == p) {
                findFather.left = null;
                return;
            } else {
                findFather.right = null;
                return;
            }
        }
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
    private Node preOderNodeFirst = null;
    private Node preOderNodeLast = null;
    private Node postOderNodeFirst = null;
    void preOderFirst(Node p) {
        // dùng preoder tìm node đầu tiên là số nguyên tố và có 2 con
        if (p == null) {
            return;
        }
        if (checkPrime(p.info.price) && p.left != null && p.right != null) {
            preOderNodeFirst = p;
            return;
        }
        preOderFirst(p.left);
        preOderFirst(p.right);
    }

    Node preOderFirst() {
        preOderFirst(root);
        return preOderNodeFirst;
    }
    void preOderLast(Node p){
        //dùng preoder tìm node cuối cùng trong tree mà keey là snt và có 2 con
        if (p==null) {
            return;
        }
        if (checkPrime(p.info.price) && p.left != null && p.right != null ) {
            preOderNodeLast=p;
        }
        preOderLast(p.left);
        preOderLast(p.right);
    }
    
    Node preOderLast(){
        preOderLast(root);
        return preOderNodeLast;
    }
    void posOrderFirst(Node p) {
        if (p == null) {
            return;
        }
        posOrderFirst(p.left);
        posOrderFirst(p.right);
        if (p.info.price % 3 == 0 & p.left != null && p.right != null) {
            postOderNodeFirst = p;
            return;
        }
    }
    void breadth_first(Node pp) {
        if (pp == null) {
            return;
        }
        MyQueue my = new MyQueue();
        my.EnQueue(pp);
        while (!my.isEmpty()) {
            Node p = my.DeQueue();
            if (p.left != null) {
                my.EnQueue(p.left);
            }
            if (p.right != null) {
                my.EnQueue(p.right);
            }
            visit(p);
        }
    }
    void breadth_first() {
        breadth_first(root);
    }
    void deleteByCopyLeft(int key){
        Node p= search(key);
        if (p==null||p.left==null) {
            return;
        }
        if (p.left.right==null) {//node ngoài cùng bên phải của con trái 
            // trùng với node con trái của node cần xóa
            p.info=p.left.info;
            p.left=p.left.left;
        } else{
            Node f=p.left;
            Node cu=p.left.right;
            while(cu.right!=null){
                f=cu;//cha cua node ngoai cung ben phai cua con trai
                cu=cu.right;
            }
            p.info=cu.info;
            f.right=cu.left;
        }
    }
     void deleteByCopyingRight(int key) {
        Node p = search(key);
        if (p == null || p.right == null) {
            return;
        }
        if (p.right.left == null) {
            p.info = p.right.info;
            p.right = p.right.right;
        } else {
            Node f = p.right;
            Node cu = p.right.left;
            while (cu.left != null) {
                f = cu;
                cu = cu.left;
            }
            p.info = cu.info;
            f.left = cu.right;
        }
    }
       void deleteByMergingLeft(int key){
        Node p = search(key);
        if(p==null || p.left==null) return;
        Node f = findFather(key);
        //tim node ngoai cung cua con ben trai
        Node cu = p.left;
        while(cu.right != null) {cu = cu.right;}
        cu.right = p.right; // gan con ben phai cua node can xoa vao vao node ngoai cung ben phai cua con ben trai
        if(root.info.price == key){//node can xoa la root
            root = root.left;
        }
        else{ // dua con trai len lam cha
            if(f.left.info.price==key) f.left = p.left;
            else f.right = p.left;
        }
    }
    
    void deleteByMergingRight(int key){
        Node p = search(key);
        if(p==null || p.right==null) return;
        Node f = findFather(key);
        //tim node ngoai cung cua con ben trai
        Node cu = p.right;
        while(cu.left != null) {cu = cu.left;}
        cu.left = p.left; // gan con ben phai cua node can xoa vao vao node ngoai cung ben phai cua con ben trai
        if(root.info.price == key){//node can xoa la root
            root = root.right;
        }
        else{ // dua con trai len lam cha
            if(f.right.info.price==key) f.right = p.right;
            else f.left = p.right;
        }
    }
    Node RightRotate(Node p){
        if (p==null||p.left==null) {
            return p;
        }
        Node c=p.left;
        Node temp=c.right;
        c.right=p;
        p.left=temp;
        return c;
    }
    void RightRotate(int key){
        Node p= search(key);
        if (p==null||p.left==null) {
            return;
        }
        Node f=findFather(key);
        Node afterRotate = RightRotate(p);
        if (f==null) {// node can quay chi la root
            root=afterRotate;
        }else{
            if (f.left.info.price==key) {
                f.left=afterRotate;
            }
            else
                f.right=afterRotate;
        }
    }
    Node LeftRotate(Node p){
        if (p==null||p.right==null) {
            return p;
        }
        Node c=p.right;
        Node temp=c.left;
        c.left=p;
        p.right=temp;
        return c;
    }
    void LeftRotate(int key){
        Node p= search(key);
        if (p==null||p.right==null) {
            return;
        }
        Node f=findFather(key);
        Node afterRotate = LeftRotate(p);
        if (f==null) {// node can quay chi la root
            root=afterRotate;
        }else{
            if (f.right.info.price==key) {
                f.right=afterRotate;
            }
            else
                f.left=afterRotate;
        }
    }
    
}

class UsingTree {

    public static void main(String[] args) {
        BSTree tr = new BSTree();
        tr.insert(new Car("A", 8));
        tr.insert(new Car("A", 4));
        tr.insert(new Car("A", 12));
        tr.insert(new Car("A", 2));
        tr.insert(new Car("A", 6));
        tr.insert(new Car("A", 10));
        tr.insert(new Car("A", 14));
        tr.insert(new Car("A", 1));
        tr.insert(new Car("A", 3));
        tr.insert(new Car("A", 5));
        tr.insert(new Car("A", 7));
        tr.insert(new Car("A", 9));
        tr.insert(new Car("A", 11));
        tr.insert(new Car("A", 13));
        tr.insert(new Car("A", 15));
        tr.inOrder();
        System.out.println("");
        tr.postOrder();
        System.out.println("");
        tr.preOrder();
        System.out.println("");
        System.out.println(tr.search(5).info);
        System.out.println(tr.findFather(5).info);
        System.out.println(tr.preOderFirst().info);
     
    }
}
