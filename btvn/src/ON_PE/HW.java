/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ON_PE;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HW {
    int f1_1 (ArrayList<Integer>a){
        int sum=0;
        for (Integer integer : a) {
            sum=sum+integer;
        }
        double tb=sum/a.size();
        int count=0;
        for (Integer integer : a) {
            if (integer>tb)
                count++;
        }
        return count;
    }
    boolean prime (int a){
        if (a<=1)
            return false;
        if(a==2||a==3)
            return true;
        for (int i = 2; i <=Math.sqrt(a); i++) {
            if (a%i==0)
                return false;
        
        }
        return true;
    }
    int f1_3(ArrayList<Integer>a){
        int sum=0;
        for (int i = 0; i <= a.size()-1; i++) {
            if(prime(i)==false)
                sum+=a.get(i);
        }
        return sum;
    }
    void f1_5(ArrayList<Integer>a){
        int min =a.get(0);
        int max=a.get(0);
        int indexmin=0;
        int indexmax=0;
        
        for (int i = 0; i <a.size()-1; i++) {
           if(a.get(i)>max){
              max = a.get(i);
              indexmax=i;
           } 
           if (a.get(i)<min){
               min=a.get(i);
               indexmin=i;
           }    
        }
        for (int i = 0; i < a.size(); i++) {
            
        }
    }
}
class using{
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        HW hw = new HW();
        a.add(1);//1+2 5 7 9
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(56);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(0);
        hw.f1_5(a);
        System.out.println(a);
    }
}
