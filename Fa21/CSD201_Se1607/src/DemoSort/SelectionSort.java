
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

/**
 *
 * @author ADMIN
 */
public class SelectionSort {
    int a[];

    public SelectionSort() {
    }

    public SelectionSort(int[] a) {
        this.a = a;
    }
    void sortSelection(){
        int n= a.length;
        sort(0,n-1);
    }
    void sort(int b, int n){
        if (b==n) {
            return;
        }
        int vtmin =b;
        for (int i = b+1; i <= n; i++) {
            if (a[vtmin]>=a[i]) {
                vtmin=i;
            }
        }
        int t=a[vtmin];
        a[vtmin]=a[b];
        a[b]=t;
        sort(b+1, n);
    }
}
