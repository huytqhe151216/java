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
public class bai40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d=0;
        int s=0;
        while(1==1){
            int test= scanner.nextInt();
            if (test==0)
                break;
            else
            {
                if (test<0){
                    d=d+1;
                    
                }
                if (test%2==0)
                    s=s+1;
            }
        }
        System.out.println(s+" "+d);
    }
}
