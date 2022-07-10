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
public class bai20 {

    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[1000];
        for (int i = 0; i < 1000; i++) {
            b[i] = 0;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (b[a[i]] == 0) {
                System.out.println(a[i]);
                b[a[i]] = 1;
            }
        }

    }
}
