
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
import models.Subject;

/**
 *
 * @author ADMIN
 */
public class SubjectDAO extends DBContext {

    public ArrayList<Subject> getSubjectHasCourse() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "select distinct   s.SubjectId, s.SubjectCode, s.SubjectName from SUBJECTS s , COURSES c\n"
                    + "where s.SubjectId= c.SubjectId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
        }

        return list;
    }

    public ArrayList<Subject> getSubject(int pageIndex) {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "select * from SUBJECTS\n"
                    + "order by SubjectId\n"
                    + "offset ? rows fetch next 20 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (pageIndex-1)*20);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
        }

        return list;
    }
    public ArrayList<Subject> getAllSubject() {
        ArrayList<Subject> list = new ArrayList<>();
        try {
            String sql = "select * from SUBJECTS\n";        
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Subject(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
        }

        return list;
    }

//    public static void main(String[] args) {
//        ArrayList<Subject> list = new ArrayList<>();
//        SubjectDAO dAO = new SubjectDAO();
//        list = dAO.getSubjectHasCourse();
//        System.out.println(list.size());
//    }
}
