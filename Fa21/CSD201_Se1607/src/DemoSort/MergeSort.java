
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
public class MergeSort {
    int  []a;

    public MergeSort() {
    }

    public MergeSort(int[] a) {
        this.a = a;
    }
    void merge(int b,int e,int m){
        // đầu vào là mảng a mà từ begin đến mid , từ mid đến end đã được sort
        //nhiệm vụ đầu ta trộn 2 phần với nhau để được 1 mảng đã sort từ begin đến end
        int []c= new int[e-b];
        int i,j,k=0;
        for ( i = b,j = m; i<m&& j<e;) {
            if (a[i]<a[j]) {
                c[k++]=a[i++];
            }else{
                c[k++]=a[j++];
                
            }//re khỏi vòng for chỉ có 1 trong 2 thằng kết thúc
        }
        if (i==m) {//i het va j phai lam tiep
            for (; j<e; j++) {
                c[k++]=a[j];
            }
        }else{
            for (; i<m; i++) {
                c[k++]=a[i];
            }
        }
        for (i = b; i < e; i++) {
            a[i]=c[i-b];
        }
    }
    void sort(int b,int e){
        if (b>=e-1) {
            return;//mang co 1 phan tu
        }
        int m=(b+e)/2;
        sort(b, m);//trai
        sort(m, e);//phai
        merge(b, e, m);//visit => postoder
    }
    void sort(){
        sort(0,a.length-1);
    }
}
