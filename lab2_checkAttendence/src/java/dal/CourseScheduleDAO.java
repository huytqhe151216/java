
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.print.Collation;
import models.CourseSchedules;

/**
 *
 * @author ADMIN
 */
public class CourseScheduleDAO extends DBContext {

    public ArrayList<CourseSchedules> getCoursesSchedulesByCourseId(int cid) {
        ArrayList<CourseSchedules> list = new ArrayList<>();
        try {
            String sql = "select cs.TeachingScheduleId, cs.TeachingDate,cs.Slot from COURSE_SCHEDULES cs\n"
                    + "where cs.CourseId =?\n"
                    + "order by cs.TeachingDate";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                CourseSchedules cs = new CourseSchedules(
                        rs.getInt(1),
                        rs.getInt(3),
                        LocalDate.parse(rs.getString(2))
                );
                list.add(cs);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    

    public Map<String, ArrayList<Integer>> getDateAndSlot(int cid) {
        Map<String, ArrayList<Integer>> hm = new HashMap<>();
        try {
            String sql = "select cs.TeachingDate, cs.Slot from COURSE_SCHEDULES cs\n"
                    + "where cs.CourseId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (hm.containsKey(rs.getString("TeachingDate"))) {
                    hm.get(rs.getString("TeachingDate")).add(rs.getInt("Slot"));
                } else {
                    ArrayList<Integer> integer = new ArrayList<>();
                    integer.add(rs.getInt("Slot"));
                    hm.put(rs.getString("TeachingDate"), integer);
                }
            }
        } catch (SQLException e) {
        }
        return hm;
    }
}
