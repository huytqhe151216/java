
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
import models.Course;
import models.Students;
import models.Subject;

/**
 *
 * @author ADMIN
 */
public class CourseDAO extends DBContext {

    public ArrayList<Course> getCourseBySubjectId(int id) {
        ArrayList<Course> listCourse = new ArrayList<>();
        try {
            String sql = "select * from COURSES  c , SUBJECTS s\n"
                    + "where c.SubjectId =? and c.SubjectId=s.SubjectId";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listCourse.add(new Course(rs.getInt("CourseId"), rs.getString("CourseCode"), new Subject(rs.getInt("subjectId"), rs.getString("SubjectCode"), rs.getString("SubjectName"))));
            }
        } catch (SQLException e) {
        }
        return listCourse;
    }

    public ArrayList<Students> getStudentsbyCourseId(int cid) {
        ArrayList<Students> list = new ArrayList<>();
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
