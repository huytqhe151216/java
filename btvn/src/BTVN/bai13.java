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
public class bai13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i=0;
        double s=0;
        int d=0;
        while(1==1){
            int test= scanner.nextInt();
            if(test==0)
                break;
            else if (test>0)
                s=s+Math.sqrt(test);
            else d++; 
        }
        System.out.println("s="+s+"."+d+ "so am");
    }
}
