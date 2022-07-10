
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
public class RollCallBooks {
    private int rollCallBookId;
    private int teachingScheduleId;
    private Students students;
    private boolean isAbsent;
    private String comment;
    public RollCallBooks() {
    }

    public RollCallBooks(int rollCallBookId, int teachingScheduleId, Students students, boolean isAbsent, String comment) {
        this.rollCallBookId = rollCallBookId;
        this.teachingScheduleId = teachingScheduleId;
        this.students = students;
        this.isAbsent = isAbsent;
        this.comment = comment;
    }

    public int getRollCallBookId() {
        return rollCallBookId;
    }

    public void setRollCallBookId(int rollCallBookId) {
        this.rollCallBookId = rollCallBookId;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public boolean isIsAbsent() {
        return isAbsent;
    }

    public void setIsAbsent(boolean isAbsent) {
        this.isAbsent = isAbsent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    
    
}
