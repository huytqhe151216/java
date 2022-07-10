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
public class access {
       class access

   {

       public int x;

private int y;

       void cal(int a, int b)

       {

           x =  a + 1;

           y =  b;

       }  

       void print()

       {

           System.out.println(" " + y);    

       }

   }  

   public class access_specifier

   {

       public static void main(String args[])

       {

           access obj = new access();  

           obj.cal(2, 3);

           System.out.println(obj.x);

           obj.print();    

       }

  }


}
