/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;

/**
 *
 * @author ADMIN
 */
public class bai25 {
    public static void giao(int []A, int []B,int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A[i]==B[j])
                    System.out.println(A[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int []A={1,3,4,5,6};
        int []B={5,6,1,2,8,9};
        giao(A ,B, A.length, B.length);
    }
}

