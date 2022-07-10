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
public class PTB2 {
    int a,b,c;
    double x1,x2,dt;
    String status;
    

    public PTB2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    void solve (){
        if (a==0)
            status ="day khong phai pt bac 2.";
        else{
            dt=b*b-4*a*c;
            status="CN";
            x1=(-b-Math.sqrt(dt))/(2*a);
            x2=(-b+Math.sqrt(dt))/(2*a);
          
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int c= scanner.nextInt();
        PTB2 pt= new PTB2(a,b,c);
        pt.solve();
        System.out.println(pt.status);
        if (pt.status.equals("CN")){
            System.out.println(pt.x1);
            System.out.println(pt.x2);
    }
    }
}
