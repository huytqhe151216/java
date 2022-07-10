
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.RollCallBooks;
import models.Students;

/**
 *
 * @author ADMIN
 */
public class RollCallBookDAO extends DBContext {

    public ArrayList<RollCallBooks> getRollCallBookBySlotAndDate(String date, int slot, int cid) {
        ArrayList<RollCallBooks> list = new ArrayList<>();
        try {
            String sql = "select rcb.RollCallBookId, cs.TeachingScheduleId , s.StudentId, s.FirstName, s.MidName,s.LastName,s.Roll#, rcb.IsAbsent,rcb.Comment from ROLL_CALL_BOOKS rcb , COURSE_SCHEDULES cs ,STUDENTS s, COURSES c\n"
                    + "where rcb.StudentId=s.StudentId and cs.CourseId=c.CourseId and rcb.TeachingScheduleId=cs.TeachingScheduleId\n"
                    + "and c.CourseId =? and cs.TeachingDate = ? and cs.Slot=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setString(2, date);
            stm.setInt(3, slot);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Students s = new Students(
                        rs.getInt("StudentId"),
                        rs.getString("Roll#"),
                        rs.getString("FirstName"),
                        rs.getString("MidName"),
                        rs.getString("LastName")
                );
                RollCallBooks rcb = new RollCallBooks(rs.getInt("RollCallBookId"), rs.getInt("TeachingScheduleId"), s, rs.getBoolean("IsAbsent"), rs.getString("Comment"));
                list.add(rcb);

            }

        } catch (SQLException e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<RollCallBooks> list = new ArrayList<>();
        RollCallBookDAO aO = new RollCallBookDAO();
        list = aO.getRollCallBookBySlotAndDate("2011-07-30", 3, 1);
        System.out.println(list.size());
    }

    public ArrayList<Integer> getRollCallBookId(String date, int slot, int cid) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String sql = "select rcb.RollCallBookId  from COURSE_SCHEDULES cs join ROLL_CALL_BOOKS rcb\n"
                    + "on cs.TeachingScheduleId = rcb.TeachingScheduleId join STUDENTS s\n"
                    + "on s.StudentId = rcb.StudentId\n"
                    + "where cs.TeachingDate = ? and cs.Slot = ? and cs.CourseId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, date);
            stm.setInt(2, slot);
            stm.setInt(3, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt("RollCallBookId"));
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public void updateAttendance(int rollCallBookId, String isAbsent, String comment) {
        try {
            String sql = "update ROLL_CALL_BOOKS\n"
                    + "set IsAbsent = ?, Comment=?\n"
                    + "where RollCallBookId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, isAbsent);
            stm.setString(2, comment);
            stm.setInt(3, rollCallBookId);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public ArrayList<RollCallBooks> getStudentsbyCourseId(int cid) {
        ArrayList<RollCallBooks> list = new ArrayList<>();
        try {
            String sql = "select * from STUDENT_COURSE sc join STUDENTS s\n"
                    + "on sc.StudentId = s.StudentId\n"
                    + "where sc.CourseId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
