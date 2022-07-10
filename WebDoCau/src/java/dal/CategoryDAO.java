
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
import models.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO extends DBContext{
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("CategoryId"), rs.getString("CategoryName")));
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public Category getCategoryByCid(int id){
        try {
            String sql = "select * from Category where CategoryId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
