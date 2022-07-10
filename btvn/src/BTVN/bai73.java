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
public class bai73 {
    public static void main(String[] args) {
        for (int i = 1; i < 5000; i++) {
            int j=i;
            int s=0;
            while(j>=10){
                s=s+(j%10)*(j%10)*(j/10);
                j=j/10;
            }
            s=s+(j%10)*(j%10)*(j/10);
            if (s==i)
                System.out.println(i);
        }
    }
  
}
