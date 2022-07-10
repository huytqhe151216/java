/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

import java.util.*;

/**
 *
 * @author ADMIN
 */
class f1 implements Comparator {
//db giảm -> string tăng -> integer giảm

    @Override
    public int compare(Object o1, Object o2) {
        int kq = 0;
        if ((o1 instanceof Integer && o2 instanceof String )|| (o1 instanceof Integer && o2 instanceof Double))
            kq =1;
        if ((o1 instanceof String && o2 instanceof Integer) || (o1 instanceof Double && o2 instanceof Integer) )
            kq=-1;
        if ( o1 instanceof Double && o2 instanceof String )
            kq =-1;
        if ( o1 instanceof String && o2 instanceof Double)
            kq=1;
        if (o2 instanceof Integer && o1 instanceof Integer) 
           kq= -Integer.compare((int)o1, (int ) o2);
        
        if (o1 instanceof Double && o2 instanceof Double)
           kq= -Double.compare((double)o1, (double)o2);
        if (o1 instanceof String && o2 instanceof String)
           kq = ((String)o1).compareTo((String)o2);
        return kq;
    }
}
class f2 implements Comparator{
// db tăng =>int tăng => string giảm
    @Override
    public int compare(Object o1, Object o2) {
       int kq=0;
       if ((o1 instanceof String && o2 instanceof Double )|| (o1 instanceof String && o2 instanceof Integer))
            kq =1;
        if ((o1 instanceof Double && o2 instanceof String) || (o1 instanceof Integer && o2 instanceof String) )
            kq=-1;
        if ( o1 instanceof Double && o2 instanceof Integer )
            kq =-1;
        if ( o1 instanceof Integer && o2 instanceof Double)
            kq=1;
        if (o2 instanceof Integer && o1 instanceof Integer) 
           kq= Integer.compare((int)o1, (int ) o2);
        
        if (o1 instanceof Double && o2 instanceof Double)
           kq= Double.compare((double)o1, (double)o2);
        if (o1 instanceof String && o2 instanceof String)
           kq = -((String)o1).compareTo((String)o2);
        return kq;
    }
    
}
class f3 implements Comparator{
    //  số giảm dần => string.

    @Override
    public int compare(Object o1, Object o2) {
       int kq=0;
       if ((o1 instanceof String && o2 instanceof Integer )|| (o1 instanceof String && o2 instanceof Double))
            kq =1;
        if ((o1 instanceof Integer && o2 instanceof String) || (o1 instanceof Double && o2 instanceof String) )
            kq=-1;
        if (o2 instanceof Integer && o1 instanceof Integer) 
           kq= -Integer.compare((int)o1, (int ) o2);
        if (o1 instanceof Integer && o2 instanceof Double) {
            if ((int) o1 > (double)o2){
                kq=-1;
            }
            else{
                kq=1;
        }
        }
        if (o1 instanceof Double && o2 instanceof Integer) {
            if ((double) o1 > (int)o2){
                kq=-1;
            }
            else{
                kq=1;
        }
        }
        if (o1 instanceof Double && o2 instanceof Double)
           kq= -Double.compare((double)o1, (double)o2);
        if (o1 instanceof String && o2 instanceof String)
           kq = ((String)o1).compareTo((String)o2);
       return kq;
    }
    
}
public class BTVNTree {
    public static void main(String[] args) {
        //TreeSet ts = new TreeSet(new f1());
        //TreeSet ts = new TreeSet(new f2());
        TreeSet ts = new TreeSet(new f3());
        
        ts.add(1);
        ts.add(2);
        ts.add("Vuong Thien Nhat");
        ts.add(3);
        ts.add("Vuong Gia Luong");
        ts.add(4.5);
        ts.add(5);
        ts.add(5.5);
        ts.add("Hua Ngan Xuyen");
//        ts.add("huy");
//        ts.add(5);
//        ts.add(9.8);
//        ts.add(10);
        System.out.println(ts);
    }
}
