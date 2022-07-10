
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

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class RadixSort {
    int []a;

    public RadixSort() {
    }

    public RadixSort(int[] a) {
        this.a = a;
    }
    void sort(){
        int n= a.length;
        int []b=new int[10];
        int []c= new int[n];
        int exp=1;
        int max=a[0];
        for (int i = 1; i < n; i++) {
            if (max<a[0]) {
                max=a[i];
            }
        }
        while (max>exp) {
            Arrays.fill(b, 0);
            for (int i = 0; i < n; i++) {
                b[a[i]/exp%10]++;//vu dong lai cac so cung gia tri lai voi nhau
                
            }
            for (int i = 1; i < 10; i++) {
                b[i]+=b[i-1];
            }
            for (int i = n-1; i >=0; i--) {
                c[--b[a[i]/exp%10]]=a[i];
            }
            for (int i = 0; i < n; i++) {
                a[i]=c[i];
            }
            exp*=10;
        }
    }
}
