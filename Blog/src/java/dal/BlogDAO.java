
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
import models.Blog;

/**
 *
 * @author ADMIN
 */
public class BlogDAO extends DBContext{
    public ArrayList<Blog>  getAllBlog(){
        ArrayList<Blog> list = new ArrayList<>();
        try {
            String sql = "select * from Blogs";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Blog(rs.getInt("BlogID"),
                        rs.getString("BlogName"), rs.getString("BlogDescription"), rs.getDate("DateCreated")));
            }
            System.out.println(list.size());
        } catch (SQLException e) {
        }
        return list;
    }
}
