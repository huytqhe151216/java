/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demostatic;

/**
 *
 * @author ADMIN
 */
public class A {
    {
        System.out.println("blockcode A1");
    }
    {
        System.out.println("blockcode A2");
    }
    static{
        System.out.println("static blockcodeA1");
    }
    static{
        System.out.println("static blockcodeA2");
    }

    public A() {
        System.out.println("constructor A");
    }
    
}
class B extends A{
     {
        System.out.println("blockcode B1");
    }
    {
        System.out.println("blockcode B2");
    }
    static{
        System.out.println("static blockcodeB1");
    }
    static{
        System.out.println("static blockcodeB2");
    }

    public B() {
        System.out.println("constructor B");
    }
}
class C extends B{
     {
        System.out.println("blockcode C1");
    }
    {
        System.out.println("blockcode C2");
    }
    static{
        System.out.println("static blockcodeC1");
    }
    static{
        System.out.println("static blockcodeC2");
    }

    public C() {
        System.out.println("constructor B");
    }
    public static void main(String[] args) {
        C c= new C();
    }
}