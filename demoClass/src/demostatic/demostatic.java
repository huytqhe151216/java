/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demostatic;
class Student {
    String id;
    String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    {
        System.out.println("block code 01");
    }
    {
        System.out.println("blockcode 02");
    }
    static {
        System.out.println("static bc 01");
    }
    static {
        System.out.println("static bc 02");
    }
//    public Student (){
//        System.out.println("day la constructor");
//    }
    
    void quyengop (double  x){
        fund=fund+x;
    }// x?0 nop them quy , x< 0 chi tieu
    static double fund;
}
/**
 *
 * @author ADMIN
 */
public class demostatic {
    public static void main(String[] args) {
        Student a = new Student("1","a");
        Student.fund =100;
        
        System.out.println("quy sinh vien="+a.fund);
        a.quyengop(50);
        Student b = new Student();
        System.out.println("tong quy :"+b.fund);
        b.fund=300;
        System.out.println("a.fund"+a.fund);
    }
}
