
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

import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
public class CourseSchedules {
    private  int teachingScheduleId;
    private int slot;
    private  LocalDate date;

    public CourseSchedules() {
    }

    public CourseSchedules(int teachingScheduleId, int slot, LocalDate date) {
        this.teachingScheduleId = teachingScheduleId;
        this.slot = slot;
        this.date = date;
    }

    public int getTeachingScheduleId() {
        return teachingScheduleId;
    }

    public void setTeachingScheduleId(int teachingScheduleId) {
        this.teachingScheduleId = teachingScheduleId;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
}
