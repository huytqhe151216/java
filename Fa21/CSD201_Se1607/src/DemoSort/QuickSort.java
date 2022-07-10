
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package DemoSort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class QuickSort {
    int a[];

    public QuickSort(int[] a) {
        this.a = a;
    }

    public QuickSort() {
    }
    // tốt nhất O(n)
    //xấu nhât O9n^2)
//    tb onlogn
    int pivot(int begin, int end){
        if (begin>end) {
            return begin;
        }
        int up=begin,t;
        int down=end;
        int x=a[end];
        while (up<down) {
            //tim phan tu dau tien ben lon hon pivot
            while (up<down && a[up]<x) {
                up++;
            }
            while(up<down&&a[down]>=x){
                down--;
            }
            if (up<down) {
                t=a[up];
                a[up]=a[down];
                a[down]=t;
            }
        }
        t=a[up];
        a[up]=a[end];
        a[end]=t;
        return up;
    }
    void sort(int begin,int end){
        if (begin>end) {
            return;
        }
        int index=pivot(begin, end);
        sort(begin, index-1);
        sort(index+1, end);//preoder
    }
    void sortQuick(){
        sort(0, a.length-1);
    }
}
//    public static void main(String[] args) {
//        Random rd= new Random();
//        int n=1000;
//        int []a= new int [n];
//        for (int i = 0; i < a.length; i++) {
//            a[i]=rd.nextInt(100);
//        }
//        QuickSort my= new QuickSort();
//        int start = s
//    }
//class using{
//    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        Random rd= new Random();
//        System.out.print("Input size of array:");
//        int n= Integer.parseInt(sc.nextLine());
//        int []a= new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i]=rd.nextInt(100);
//        }
//        QuickSort quickSort = new QuickSort();
//        quickSort.sortQuick();
//    }
//}
