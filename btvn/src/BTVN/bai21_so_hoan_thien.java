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
public class bai21_so_hoan_thien {
    public static int check(int a){
        int sum=0;
        for (int i = 1; i < a; i++) {
            if(a%i==0)
                sum=sum+i;
        }
        if (sum==a)
            return 1;
        else 
            return 0;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if(check(i)==1)
                    System.out.println(i);
        }
    }
}
