
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
public class MySort {
    boolean check( int a[]){
       int n= a.length;
        for (int i = 1; i < n; i++) {
            if (a[i]<a[i-1]) {
                return false;
            }
        }
       return true;
    }
    
    void display(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+", ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Random rd= new Random();
        System.out.print("Input size of array:");
        int n= Integer.parseInt(sc.nextLine());
        int []a= new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=rd.nextInt(100);
        }
        MySort my =  new MySort();
        my.display(a);
        RadixSort sort= new RadixSort(a);
        sort.sort();
        my.display(a);
        System.out.println("Check = "+my.check(a));
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
    }
}
