/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoHeap;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Benjamin
 */
public class DemoHeap {
    int[] a;
    public DemoHeap(){
        
    }
    
    public DemoHeap(int[] a){
        this.a = a;
    }
    void display(){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println("");
    }
    
    void heapTopDown(){
        int n = a.length;
        for (int i = 1; i < n; i++){
            int x = a[i];
            int c = i;
            int f = (c-1)/2;
            while ((c > 0) && (a[f] < x)){
                a[c] = a[f];
                c = f;
                f = (c-1)/2;
            }
            a[c] = x;
        }
    }
    
    void heapBottomUp(){
        int n = a.length-1;
        for (int i = (n-1)/2; i >= 0; i--){
            int f = i;
            do{
               int c = 2 * f + 1;
                if ((c + 1) <= n && a[c] < a[c + 1]){
                    c = c + 1;
                }
                if (a[f] < a[c]){
                    int temp = a[f];
                    a[f] = a[c];
                    a[c] = temp;
                }
                f = c;
            } while (2*f+1 <= n);           
        }
    }
    
    boolean check(){
        for (int i = 1; i < a.length; i++){
            if(a[i] > a[(i-1)/2]){
                return false;
            }
        }
        return true;
    }
    
   
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Input size of array: ");
        int n = Integer.parseInt(sc.nextLine());
        int []a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = rd.nextInt(100);
        }
        DemoHeap d= new DemoHeap(a);
        d.display();
        d.heapBottomUp();
        d.display();
        System.out.println(d.check());
    }
}