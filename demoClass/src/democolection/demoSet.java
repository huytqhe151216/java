/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democolection;

import java.util.HashSet;
import java.util.*;
// viet chuong trinh cho phep treeset luu tru  gồm : string, integer
// trong do String dung trước intergeer , nếu cùng tring thì sort giảm dần của từ điển.
// neus cùng interger thì sort tăng dần
//string giảm -> interger tăng.
class Mysort   implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
       int kq=0;
       if (o1 instanceof Integer && o2 instanceof String) kq=1;
       if (o2 instanceof Integer && o1 instanceof String) kq=-1;
       if (o2 instanceof Integer && o1 instanceof Integer) 
           kq= Integer.compare((int)o1, (int ) o2);
       if (o1 instanceof String && o2 instanceof String)
           kq = -((String)o1).compareTo((String)o2);
       //To change body of generated methods, choose Tools | Templates.
       return -kq;
    }
    
}
class DemoSet{
    public static void main(String[] args) {
        Mysort my= new Mysort();
        
        TreeSet ts = new TreeSet(my);
        ts.add(10);
        ts.add(15);
        ts.add(20);
        ts.add(5);
        ts.add("khong biet");
        ts.add("khong biet2");
        ts.add("khong biet1");
        System.out.println(ts);
    }
}    
/*
class Student {
    String id;
    String name;
    int GPA;

    public Student(String id, String name, int GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", GPA=" + GPA + '}';
    }
    
    
}
class MySort implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        return -1; //To change body of generated methods, choose Tools | Templates.
    }

    
}
class DemoSet{
    public static void main(String[] args) {
        MySort my = new MySort();
        
        TreeSet ts = new TreeSet(my);
        ts.add(new Student("he151216","nguyen van a",80));
        ts.add(new Student("he15126","nguyen van b",80));
        System.out.println("ts =");
        for (Object  t : ts){
            System.out.println(t);
    }
}
}
//class MySort implements  Comparator<Integer>{
//
//    @Override
//    public Comparator<Integer> reversed() {
//        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
//    }
//    
//}
    /**
 *
 * @author ADMIN
 */
//public class demoSet {
//    public static void main(String[] args) {
//        TreeSet ts = new TreeSet();
//        ts.add(10);
//        ts.add(5);
//        ts.add(20);
//        ts.add(15);
//        System.out.println(ts);
//        HashSet hs = new HashSet();
//        hs.add(10);
//        hs.add(true);
//        hs.add("hello");
//        hs.add(new Integer(10));
//        hs.add(new String("hello"));
//        //khong co hs.add(index,object)
//        // khong addAll(indext, collection)
////       
//// trong set khong co update set(index, value);
//        hs.contains(obj);
//        hs.containsAll(hs);
//        hs.clear();
//        hs.isEmpty();
//        
//        System.out.println("hs= "+hs);
//        for (Object h: hs){
//            System.out.println(h+" '");
//        }
  //  }
    
//}
