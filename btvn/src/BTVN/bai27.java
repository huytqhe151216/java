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
public class bai27 {

    public static void main(String[] args) {
        for (int traudung = 1; traudung < 100; traudung++) {
            for (int traunam = 1; traunam < 100; traunam++) {
                if (5*traudung + 3*traunam +  (100 - traudung - traunam)/3 == 100 && (100-traudung-traunam)%3==0) {
                    System.out.println("dung-nam-ngoi " + traudung +" "+ traunam +" " + (100 - traudung - traunam));
                }
            }
        }

    }

}
