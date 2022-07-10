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
public class bai9 {
    public static int gt(int b){
        int x=1;
        for (int i = 1;i<=b ;i++) {
            x=x*i;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner (System.in);
        double a=scanner.nextDouble();
        int n=1;
        double s=0;
        while(1.0/gt(n)>a){
            s=s+1.0/gt(n);
            n++;
        }
        System.out.println("s="+s);
    }
}
