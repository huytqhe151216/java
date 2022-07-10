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
public class bai8 {
    public static void main(String[] args) {
        double   a=72000000;
        for (int i = 1994; i < 2500; i++) {
            a = a + a*2.3/100;
            if (a>108000000){
                    System.out.println("năm "+i);
                    break;
        }
    }
    
}
}
