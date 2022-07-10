/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democlass;

/**
 *
 * @author ADMIN
 */
public class DemoClass {
    String id;
    String name;
    boolean gender;
    int age;
    double GPA;
    void setName (String s){
        name = s;
    }
    String getName(){
        return name;
    }
    void setGPA (double tb){
        GPA = tb;
    }
    double getGPA(){
        return GPA;
    }
class UssingStudent{
    
    public static void main(String[] args) {
        // TODO code application logic here
        Student stA=new Student();
        stA.setName("nguyen van a");
        stA.setGPA(8);
        System.out.println("sinh vien co ten"+stA.getName()+ "co GPA"+stA.getGPA();
    }
    
}
