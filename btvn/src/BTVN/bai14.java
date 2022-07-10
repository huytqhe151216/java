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
public class bai14 {
    int n;

    public bai14(int n ) {
        this.n = n;
    }
    void solve(){
        for (int i = 2; i < n+1; i++) {
            if(n%i==0)
                System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n= scanner.nextInt();
        bai14 bai14_ = new bai14(n);
        bai14_.solve();
        
    }
    
}
