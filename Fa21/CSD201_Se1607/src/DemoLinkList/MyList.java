/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLinkList;

/**
 *
 * @author ADMIN
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void f1(int value) {// kierm tra xem value co phai snt hay khong
        // neu la snt thi do nothing neu khong thi them value vao cuoi list
        if (checkPrime(value)) {

        } else {
            addLast(value);
        }
    }

    void mydel() {
        //xoa bo phan tu dau tien la snt
        Node cur = head;
        int pos = 0;

        while (cur != null) {
            if (checkPrime(cur.value)) {
                deleteIndex(pos);
                break;
            }
            pos++;
            cur = cur.next;
        }
    }

    static boolean checkPrime(int value) {
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;

            }
        }
        return true;
    }

    void addIndex(int value, int index) {
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node cur = head; // di tim vi tri cua nodee can add
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
                addLast(value);// vi tri can add chinh la vi tri cuoi cung
            } else {
                Node node = new Node(value);
                node.next = cur.next;
                cur.next = node;
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

    Node findFather(int index) {
        if (index <= 0) {
            return null;
        }
        Node cur = head;
        int pos = 0;
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

    void addIndex1(int value, int index) {
        //BTVN
        if (index < 0) {
            return;
        }
        if (index == 0) {
            addFirst(value);
        } else {
            Node add = new Node(value);

            Node father = findFather(index);
            if (father == null || father == tail) {
                return;
            }
            if (father.next == tail) {
                addLast(value);
            } else {
                add.next = father.next;
                father.next = add;
            }
        }
    }

    int delFirst() {
        int value = Integer.MIN_VALUE;
        if (isEmpty()) {
            return value;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            value = head.value;
            head = head.next;

        }
        return value;
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

    int delLast() {
        int value = Integer.MIN_VALUE;
        if (isEmpty()) {
            return value;
        }
        if (head == tail) {
            value = tail.value;
            head = tail = null;
        } else {
            Node cur = head;// ta di tim cur cha cua tail
            while (cur.next != tail) {
                cur = cur.next;
            }
            value = tail.value;
            cur.next = null;
            tail = cur;
        }
        return value;
    }

    int delIndex(int index) {
        int value = Integer.MIN_VALUE;
        if (index < 0) {
            return value;
        }
        if (index == 0) {
            value = delFirst();
        } else {
            Node cur = head;//tim vvi tri cha cua node can xoa
            int pos = 0;
            while (cur.next != null) {
                if (index - 1 == pos) {
                    break;
                }
                cur = cur.next;
                pos++;
            }
            if (cur == tail) {

            }// index qua lon so voi size;
            else if (cur.next == tail) {//node can xoa la tail
                value = delLast();
            } else {
                value = cur.next.value;
                cur.next = cur.next.next;
            }
        }
        return value;
    }

    void deleteIndex1(int index) {
        int value = 0;
        if (index < 0) {
            return;
        }
        if (index == 0) {
            deleteFirst();
        } else {
            Node father = findFather(index);
            if (father == null || father == tail) {
                return;
            }
            if (father.next == tail) {
                deleteLast();
            } else {
                value = father.next.value;
                father.next = father.next.next;
            }
        }
    }

    void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    Node findValue(int index) {
        if (index < 0) {
            return null;
        }

        Node cur = head;
        int pos = 0;
        while (cur != null && pos < index) {
            pos++;
            cur = cur.next;
        }

        return cur;

    }

    int findIndex1(int value) {
        //tim va tra ve vi tri dau tien cua node co gia tri bang value
        Node cur = head;
        int pos = 0;
        while (cur != null) {
            if (cur.value == value) {
                return pos;
            }
            pos++;
            cur = cur.next;
        }
        return -1;
    }

    int findIndex2(int value) {
        // tim va tra ve vi tri cuoi cung co gia tri bang value
        Node cur = head;
        int pos = 0;
        int indexLast = Integer.MIN_VALUE;
        while (cur != null) {
            if (cur.value == value) {
                indexLast = pos;
            }
            pos++;
            cur = cur.next;
        }

        return indexLast;
    }

    int findIndexFirstMax() {
        //tim va tra ve vi tri dau tien cua node co gia tri lon nhat
        Node cur = head;
        int pos = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        while (cur != null) {
            if (cur.value > maxValue) {
                maxValue = cur.value;
                maxIndex = pos;
            }
            pos++;
            cur = cur.next;
        }
        return maxIndex;
    }

    int findIndexLastMax() {
        //tim va tra ve vi tri cuoi cung cua node co gia tri lon nhat
        Node cur = head;
        int pos = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        while (cur != null) {
            if (cur.value >= maxValue) {
                maxValue = cur.value;
                maxIndex = pos;
            }
            pos++;
            cur = cur.next;
        }
        return maxIndex;
    }

    int findIndexLastMin() {
        //tim va tra ve vi tri cuoi cung cua node co gia be nhat nhat
        Node cur = head;
        int pos = 0;
        int minValue = cur.value;
        int minIndex = -1;
        while (cur != null) {
            if (cur.value <= minValue) {
                minValue = cur.value;
                minIndex = pos;
            }
            pos++;
            cur = cur.next;
        }
        return minIndex;
    }

    int findIndexFirstMin() {
        //tim va tra ve vi tri dau tien cua node co gia be nhat nhat
        Node cur = head;
        int pos = 0;
        int minValue = cur.value;
        int minIndex = -1;
        while (cur != null) {
            if (cur.value < minValue) {
                minValue = cur.value;
                minIndex = pos;

            }
            pos++;
            cur = cur.next;
        }
        return minIndex;
    }

    void swapSpring2021() {
        // tim cai node co gia tri lon nhat dau tien va node co gia tri be nhat cuoi cung
        // sau do doi cho gia tri 2 node do cho nhau
        Node a = findValue(findIndexFirstMax());
        Node b = findValue(findIndexLastMin());
        swap(a, b);
    }

    void swapSpring2021Ver2() {
        //tìm node đầu tiên có giá trị lớn nhất thứ 2 và node cuối cùng có giá trị bé nhất thứ 2 sau đó đổi chỗ giá trị 2 node này cho nhau
        Node cur = head;
        int pos = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        int minValue = cur.value;
        int minIndex = 0;
        while (cur != null) {
            if (cur.value > maxValue && cur.value != findValue(findIndexFirstMax()).value) {
                maxValue = cur.value;
                maxIndex = pos;
            }
            if (cur.value <= minValue && cur.value != findValue(findIndexLastMin()).value) {
                minValue = cur.value;
                minIndex = pos;
            }
            pos++;
            cur = cur.next;
        }
       
        swap(findValue(minIndex), findValue(maxIndex));
    }
    void swapSpring2021Ver3(){
         //tìm node đầu tiên là số nguyên tố và node cuối cùng là số chẵn sau đó đổi chỗ 2 node đó cho nhau
         Node cur= head;
         int pos=0;
         int indexPrime=-1;
         while(cur!=null){
             if (checkPrime(cur.value)){
                 indexPrime=pos;
                 break;
             }
             pos++;
             cur=cur.next;
         }
         Node cur1=head;
         pos=0;
         int indexEven=-1;
         while(cur1!=null){
             if (cur1.value%2==0)
                 indexEven=pos;
             pos++;
             cur1=cur1.next;
         }
         swap(findValue(indexEven),findValue(indexPrime));
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

    int findIndex(int value) {
        //tim va tra va vi tri dau tien cua node co gia tri bang value
        //tim va tra va vi tri cuoi cung  cua node co gia tri bang value
        //tim va tra ve vi tri cua node co gia tri lon nhat dau tien
        //tim va tra ve vi tri cua node co gia tri lon nhat cuoi cung
        //tim va tra ve vi tri cua node co gia tri be nhat dau tien
        //tim va tra ve vi tri cua node co gia tri be nhat cuoi cung
        //spring 2021: cho 1 cai list luu tru 1 doi tuong nao do
        // tim cai node co gia tri lon nhat dau tien va node co gia tri be nhat cuoi cung
        // sau do doi cho gia tri 2 node do cho nhau
        //tìm node đầu tiên có giá trị lớn nhất thứ 2 và node cuối cùng có giá trị bé nhất thứ 2 sau đó đổi chỗ giá trị 2 node này cho nhau
        // tim và trả về vị trí đầu tiên thõa mản điều kiện abc nào đó
        //tìm node đầu tiên là số nguyên tố và node cuối cùng là số chẵn sau đó đổi chỗ 2 node đó cho nhau
        return -1;
    }

    void display() {
        Node cur = head;// di tim vi tri cha cua node can add
        while (cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyList my = new MyList();//list empty
        my.addFirst(20);
        my.addFirst(10);
        my.addFirst(2);
        my.addFirst(1);
        my.addFirst(4);
        my.addFirst(5);
        my.addLast(1);
        my.addLast(10);
        my.addFirst(20);
        my.display();
        my.swapSpring2021Ver3();
        my.display();
//        Node a = my.findValue(0);
//        Node b = my.findValue(4);
//        System.out.println(b.value);
//        my.swap(a, b);
//        my.display();
//        my.addIndex(2,5);
//        my.display();
//        int a=my.delLast();
//        System.out.println(a);
//        int b= my.delFirst();
//        System.out.println(b);
//        my.display();
//          my.deleteLast();
//          my.display();
//          int b=my.delIndex(2);
//          System.out.println(b);
//          my.display();
//           System.out.println(my.delIndex(2));
//           my.display();
//        my.mydel();
//        my.display();
//            my.addIndex1(10, 3);
//            my.display();
//        my.addIndex1(3, 1);
//        my.display();
    }
}
