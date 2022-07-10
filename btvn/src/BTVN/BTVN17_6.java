/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 *
 * @author ADMIN
 */
public class BTVN17_6 {

    int checksnt(int x) {
        if (x < 2) {
            return 0;
        }
        if (x == 2 || x == 3) {
            return 1;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    // tinh va tra ve tong cac so nguyen to co trong list a
    void bai1(ArrayList<Integer> ar) {
        int sum = 0;
        for (Integer x : ar) {
            if (checksnt(x) == 1) {
                sum += x;
            }
        }
        System.out.println("tong cac so nguyen to la: " + sum);
    }

    //dem va tra ve so cac so nguyen to co trong list a
    void bai2(ArrayList<Integer> ar) {
        int d = 0;
        for (Integer x : ar) {
            if (checksnt(x) == 1) {
                d = d + 1;
            }
        }
        System.out.println(" số các số nguyên tố trong list là:" + d);
    }

    // tính và trả về tổng tích của nửa đầu các số có trong list a
    // không tính phần tử giữa nếu có
    void bai3(ArrayList<Integer> ar) {
        int sum = 0;
        int prod = 1;
        for (int i = 0; i < ar.size() / 2; i++) {
            sum += ar.get(i);
            prod *= ar.get(i);
        }
        System.out.println("Tong la:" + sum + " Tich la:" + prod);
    }

    //tính tổng hiệu tích thương số lớn nhất và số bé nhất
    void bai4(ArrayList<Integer> ar) {
        int max = ar.get(0);
        int min = ar.get(0);
        for (Integer x : ar) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }
        System.out.println("Tong la:" + (max + min) + "hieu la:" + (max - min));
        System.out.println("Thuong la:" + (max / min) + "tich la :" + (max * min));
    }

    // tính tổng của tất cả 2 loại số lớn nhất trong list
    void bai5(ArrayList<Integer> list) {
        int sum = 0;
        Collections.sort(list, Collections.reverseOrder());
        int Max1 = list.get(0);
        int Max2 = 0;
        int lastIndexNeed = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != Max1) {
                lastIndexNeed = i;
                Max2 = list.get(i);
                break;
            }
        }
        for (int i = lastIndexNeed + 1; i < list.size(); i++) {
            if (list.get(i) != Max2) {
                lastIndexNeed = i;
                break;
            }
        }
        for (int i = 0; i < lastIndexNeed; i++) {
            sum += list.get(i);
        }
        System.out.println("tong la " + sum);
    }

    //sort 5 phần tử đầu tiên  theo thứ tự giảm dần
    //reverse 5 phần tử cuối
    void bai6(ArrayList<Integer> ar) {
        System.out.println(ar);
        for (int i = 0; i < 4; i++) {
            for (int j = i; j <= 4; j++) {
                if (ar.get(i) < ar.get(j)) {
                    int tg = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tg);
                }
            }
        }
        int tg = ar.get(ar.size() - 1);
        ar.set(ar.size() - 1, ar.get(ar.size() - 5));
        ar.set(ar.size() - 5, tg);

        int tg2 = ar.get(ar.size() - 2);
        ar.set(ar.size() - 2, ar.get(ar.size() - 4));
        ar.set(ar.size() - 4, tg2);
        System.out.println(ar);
    }

    // giả sử sô phần tử trong list là chẵn >=2
    // chia list thành  2 phần rồi sắp xếp
    void bai7(ArrayList<Integer> ar) {
        System.out.println(ar);
        for (int i = 0; i < ar.size() / 2 - 1; i++) {
            for (int j = i; j < ar.size() / 2 - 1; j++) {
                if (ar.get(i) > ar.get(j)) {
                    int tg = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tg);
                }
            }
        }
        for (int i = ar.size() - 1; i >= ar.size() / 2; i--) {
            for (int j = i; j >= ar.size() / 2; j--) {
                if (ar.get(i) < ar.get(j)) {
                    int tg = ar.get(i);
                    ar.set(i, ar.get(j));
                    ar.set(j, tg);
                }
            }
        }
        System.out.println(ar);
    }

    // cho collection, thay the tat ca cac phan tu trong list a = uoc so nguyen to lon nhat cua phan tu ay
    int UocSntMax(int a) {
        int max = 1;
        for (int i = 1; i <=a; i++) {
            if (a%i==0 && checksnt(i) == 1) {
                max = i;
            }
        }
        return max;
    }

    void bai8(ArrayList<Integer> ar) {
        System.out.println(ar);
        for (int i = 0; i < ar.size(); i++) {
            ar.set(i, UocSntMax(ar.get(i)));
        }
        System.out.println(ar);
    }
}

class using {

    public static void main(String[] args) {
        BTVN17_6 hw = new BTVN17_6();
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ar.add(sc.nextInt());
        }
        //hw.bai1(ar);
        //hw.bai2(ar);
        //hw.bai3(ar);
        //hw.bai4(ar);
        //hw.bai5(ar);
        //hw.bai6(ar);
        hw.bai8(ar);

}
}
    
