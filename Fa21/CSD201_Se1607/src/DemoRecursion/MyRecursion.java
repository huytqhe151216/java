/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoRecursion;

/**
 *
 * @author ADMIN
 */
public class MyRecursion {
    long fac(int n){
//        if (n==0 )
//            return 1;
//        else
//            return n*fac(n-1);
    return n==0?1:n*fac(n-1);
    }
    int fib(int n){
        return n<2?1:fib(n-2)+fib(n-1);
    }
    String rev (String s){
        if (s.length()<=1)
            return s;
        else
            return rev(s.substring(1))+s.charAt(0);
    }
    String conVert (int n, int base){
        // doi so n trong co so 10 sang co so base
        if (n<base) return change(n)+"";
        else
            return conVert(n/base, base)+change(n%base);
    }
    char change(int n){
        return (char)(n<10?(n+48):(n+55));
    }
    public static void main(String[] args) {
        MyRecursion my = new MyRecursion();
        System.out.println(my.conVert(151216, 5));
    }
}
