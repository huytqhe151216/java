/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTVN;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class bai18 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int []a = new int [100];
        int n= scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int j=0;
        int d=0;
        int dmax=0;
        while(j<n ){
            if (a[j]==0){
                d++;
                j++;
            }
            else{
               d=0;
               j++;
            }
            if(d>dmax)
               dmax=d;
        }
        System.out.println("day con dai nhat "+dmax+" phan tu");
    }
}
