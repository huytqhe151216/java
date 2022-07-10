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
public class PTB1 {
    int a,b;
    double x;
    String status;

    public PTB1(int a, int b) {
        this.a = a;
        this.b = b;
    }
    void solve(){
        if (a==0){
            if (b==0){
                status = " phuong trinh co vo so nghiem";
            }
            else
                status ="phuong trinh vo nghiem";
        }
        else{
            status ="CN";
            x=-(b+0.0)/a;
        }
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        PTB1 pt = new PTB1(a, b);
        
        pt.solve();
        System.out.println(pt.status);
        if (pt.status.equals("CN")) 
            System.out.println(pt.x);
        
    }
    
    
    
}
