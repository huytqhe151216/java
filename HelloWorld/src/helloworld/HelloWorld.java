/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author ADMIN
 */
public class HelloWorld {

    static int sum(int... a) {
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        return sum;
    }
    static void swap (int a, int b){
        int t;
        t=a;
        a=b;
        b=t;
        
    }
    static  void swap1 (int []a){
        int t= a[0];
        a[0]=a[1];
        a[1]=t;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        // TODO code application logic here
        int a=5,b=6;
        
        System.out.println("befor a="+a+"b="+b);
        swap(a,b);
        System.out.println("after a="+a+"b="+b);
        System.out.println("a=%2$d, b=%d",a,b);
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        
       
        // di chuyen mot hoac nhieu dong len tren hoac xuong duoi :alt shift ip/down
        // ctrl + shift up/down arrow
        //shift fn up/down arrow
        // ctrl + / comment uncomment
        //alt + shift +f: format code
    }

}
