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
public class bai55 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int x = 0;
        if (a <=4) {
            System.out.println(5000*a);
        }
        else if (a<=19)
            System.out.println(5000*4+3000*(a-4));
        else
            System.out.println(5000*4+3000*(a-4)+(a-20)*2000);
    }
}
