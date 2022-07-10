
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Students {

    private int studentId;
    private String roll;
    private String firstName;
    private String midName;
    private String lastName;

    public Students() {
    }

    public Students(int studentId, String roll, String firstName, String midName, String lastName) {
        this.studentId = studentId;
        this.roll = roll;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName(){
        if(midName == null){
            return firstName + " " +lastName;
        } else {
            return firstName + " " + midName + " " + lastName;
        }
    }
    
}
