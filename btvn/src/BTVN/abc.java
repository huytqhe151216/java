/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vietanhdang
 */
public class abc {

    boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // xoa bo toan bo cac phan tu so nguyen to co trong arr
    void f1(ArrayList<Integer> ar) {
        // dinh nghia va viet chuong trinh kiem tra 15 loai so nguyen khac nhau
        for (int i = 0; i < ar.size(); i++) {
            if (checkPrime(ar.get(i))) {
                ar.remove(i);
                i--;
                
            }
        }
        System.out.println("After remove prime process   : " + ar);

    }

    // sort toan bo cac phan tu co trong collection ar(bubble,interchange,selection)
    void f2(ArrayList<Integer> ar) {
        Collections.sort(ar);
        System.out.println("After sorting process        : " + ar);
    }

    // sort toan bo cac phan tu la so nguyen to con cac phan tu khac dung yen
    void f3(ArrayList<Integer> ar) {
        ArrayList<Integer> tempValue = new ArrayList<>();
        ArrayList<Integer> tempIndex = new ArrayList<>();
        for (int i = 0; i < ar.size(); i++) {
            if (checkPrime(ar.get(i))) {
                tempIndex.add(i);
                tempValue.add(ar.get(i));
            }
        }
        Collections.sort(tempValue);
        for (int i = 0; i < tempValue.size(); i++) {
            ar.set(tempIndex.get(i), tempValue.get(i));
        }
        System.out.println("After sorting prime process  : " + ar);
    }

    // them vao truoc phan tu la so nguyen to dau tien trong mang mot so 100
    void f4(ArrayList<Integer> ar) {
        int i = 1;
        for (Integer x : ar) {
            if (checkPrime(x)) {
                break;
            }
            i++;
        }
        if (i <= ar.size()) {
            ar.add(i - 1, 100);
        }
        System.out.println("After add 100 before prime   : " + ar);
    }

}

class Using {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        abc hw = new abc();
        ArrayList<Integer> ar = new ArrayList<>();
        System.out.println("Input size of Collection = 10");
        int n = 10;
        for (int i = 0; i < n; i++) {
            ar.add(sc.nextInt());
        }
        System.out.println("Before process               : " + ar);
        //hw.f1(ar);
        //hw.f2(ar);
        //hw.f3(ar);
        hw.f4(ar);

    }
}