
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
public class HeapSort {

    int[] a;
    
    public HeapSort() {
    }
    
    public HeapSort(int[] a) {
        this.a = a;
    }
    
    void heap() {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int x = a[i];
            int c = i;
            int f = (c - 1) / 2;
            while (c > 0 && a[f] < x) {
                a[c] = a[f];
                c = f;
                f = (c - 1) / 2;
            }
            a[c] = x;
        }
    }

    void sort() {
        heap();
        int n = a.length - 1;
        for (int i = n; i > 0; i--) {//vi tri i la vi tri can reheap
            int x = a[i];
            a[i] = a[0];
            int f = 0;
            int c = 2 * f + 1;// mac dinh chon con trai
            if (c + 1 < i && a[c + 1] > a[c]) {
                c = c + 1;
            }
            while (c < i && a[c] > x) {
                a[f]=a[c];
                f=c;
                c=2*f+1;
                if (c+1<i&&a[c+1]>a[c]) {
                    c++;
                }
            }
            a[f]=x;
        }
    }
}
