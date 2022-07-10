/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN24_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ADMIN
 */
class f1 implements Comparator<Object> {
    //db giam string tang int giam
    @Override
    public int compare(Object o1, Object o2) {
        int kq = 0;
        if (o1 instanceof Integer && o2 instanceof String || o1 instanceof Integer && o2 instanceof Double) {
            kq = 1;
        }
        if (o2 instanceof Integer && o1 instanceof String || o2 instanceof Integer && o1 instanceof Double) {
            kq = -1;
        }
        if (o1 instanceof Double && o2 instanceof String) {
            kq = -1;
        }
        if (o1 instanceof String && o2 instanceof Double) {
            kq = 1;
        }
        if (o1 instanceof Double && o2 instanceof Double) {
            kq = -Double.compare((double) o1, (double) o2);
        }
        if (o1 instanceof String && o2 instanceof String) {
            kq = ((String) o1).compareTo(((String) o2));
        }
        if (o1 instanceof Integer && o2 instanceof Integer) {
            kq = -Integer.compare((int) o1, (int) o2);
        }
        
        return kq;
    }
    
}

class f2 implements Comparator<Object> {
    //db tang int tang string giam
    @Override
    public int compare(Object o1, Object o2) {
        int kq = 0;
        if (o1 instanceof String && o2 instanceof Integer || o1 instanceof String && o2 instanceof Double) {
            kq = 1;
        }
        if (o2 instanceof String && o1 instanceof Integer || o2 instanceof String && o1 instanceof Double) {
            kq = -1;
        }
        if (o1 instanceof Double && o2 instanceof Integer) {
            kq = -1;
        }
        if (o1 instanceof Integer && o2 instanceof Double) {
            kq = 1;
        }
        if (o1 instanceof Double && o2 instanceof Double) {
            kq = Double.compare((double) o1, (double) o2);
        }
        if (o1 instanceof String && o2 instanceof String) {
            kq = -((String) o1).compareTo(((String) o2));
        }
        if (o1 instanceof Integer && o2 instanceof Integer) {
            kq = Integer.compare((int) o1, (int) o2);
        }
        return kq;
    }
    
}

class f3 implements Comparator<Object> {
    //number giam tring 
    @Override
    public int compare(Object o1, Object o2) {
        int kq = 0;
        if (o1 instanceof String && o2 instanceof Integer || o1 instanceof String && o2 instanceof Double) {
            kq = 1;
        }
        if (o2 instanceof String && o1 instanceof Integer || o2 instanceof String && o1 instanceof Double) {
            kq = -1;
        }
        
        if (o1 instanceof Double && o2 instanceof Integer) {
            kq = -1;
        }
        if (o1 instanceof Integer && o2 instanceof Double) {
            kq = 1;
        }
        
        if (o1 instanceof Double && o2 instanceof Double) {
            kq = -Double.compare((double) o1, (double) o2);
        }
        if (o1 instanceof Integer && o2 instanceof Integer) {
            kq = -Integer.compare((int) o1, (int) o2);
        }
        if (o1 instanceof String && o2 instanceof String) {
            kq = ((String) o1).compareTo(((String) o2));
        }
        
        if (o1 instanceof Double && o2 instanceof Integer) {
            if ((double) o1 > (int) o2) {
                kq = -1;
            } else {
                kq = 1;
            }
        }
        if (o1 instanceof Integer && o2 instanceof Double) {
            if ((int) o1 > (double) o2) {
                kq = -1;
            } else {
                kq = 1;
            }
        }
        
        return kq;
    }
    
}

public class AnnonymousOB {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Vuong Thien Nhat");
        list.add(2.5);
        list.add(3.5);
        list.add(2);
        list.add(3);
        list.add("Vuong Gia Luong");
        //Collections.sort(list, new f1());
        //Collections.sort(list, new f2());
        Collections.sort(list, new f3());
        System.out.println(list);
    }
}
