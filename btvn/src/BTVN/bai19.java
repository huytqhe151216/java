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
public class bai19 {
    public static int check(int a){
        int x=0;
        int b=a;
       while(a>10){
          x=10*x+a%10;
          a=a/10;
       }
       if(b==10*x+a)
            return 1;
       else
           return 0;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            if(check(i*i)==1)
                System.out.println(i);
        }
    }
}
