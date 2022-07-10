/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Menu extends Vector<String>{

    public Menu() {
        super();
    }
    void addMenuItem(String s){
        this.add(s);
    }
    int getUserChoice(){
        for (int i = 0; i < this.size(); i++) {
            System.out.println(i+1 +". "+this.get(i));
        }
        Scanner sc= new Scanner(System.in);
        int c = sc.nextInt();
        return c;
    }
}
