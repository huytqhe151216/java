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
public class bai3 {
    public static int gt(int a){
        int x=1;
        for (int i = 1; i <=a; i++) {
            x=x*i;
        }
        return x;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int k=i;
            int h=0;
            int s=0;
            while(k>=10){
                h=k%10;
                k=k/10;
                s=s+gt(h);
            }
            s=s+gt(h);
            if (s==i)
                    System.out.println(i);
        }
    }
}
