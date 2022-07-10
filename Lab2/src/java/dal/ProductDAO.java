
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
import models.Category;
import models.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProductsByPage(int page) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName, p.UnitPrice, c.CategoryID, c.CategoryName, c.Description, p.UnitsInStock from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                    + "ORDER BY p.ProductID OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, (page - 1) * 8);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"),
                        rs.getString("Description"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getFloat("UnitPrice"),
                        cat,
                        rs.getInt("UnitsInStock")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public ArrayList<Product> getProductsByCateID(int page, int cid) {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName, p.UnitPrice, c.CategoryID, c.CategoryName, c.Description, p.UnitsInStock from Products p join Categories c on p.CategoryID = c.CategoryID and c.CategoryID = ?\n"
                    + "ORDER BY p.ProductID OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, (page - 1) * 8);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category cat = new Category(
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName"),
                        rs.getString("Description"));
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getFloat("UnitPrice"),
                        cat,
                        rs.getInt("UnitsInStock")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public int getNumberOfProducts() {
        int number = 0;
        try {
            String sql = "select count(*) from Products p, Categories c where p.CategoryID = c.CategoryID";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }

    public int getNumberOfProductsByCid(int cid) {
        int number = 0;
        try {
            String sql = "select count(*) from Products p, Categories c where p.CategoryID = c.CategoryID and c.CategoryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                number = rs.getInt(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return number;
    }
}
