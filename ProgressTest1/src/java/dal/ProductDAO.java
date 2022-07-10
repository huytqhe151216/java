
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
import model.Category;
import model.Products;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public int countAllProductByCategoryId(int cid) {

        try {
            String sql = "select count(*) from Products \n"
                    + "where CategoryID =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    public int countAllProduct() {

        try {
            String sql = "select count(*) from Products \n"
                    ;
            PreparedStatement stm = connection.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public ArrayList<Products> getProductByCid(int cid, int page) {
        ArrayList<Products> listProducts = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName,p.CategoryID,p.UnitPrice,p.UnitsInStock,c.CategoryName from Products p ,Categories c\n"
                    + "where p.CategoryID = c.CategoryID \n"
                    + "and c.CategoryID=? \n"
                    + "order by p.ProductID\n"
                    + "offset ? rows fetch next 9 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            stm.setInt(2, (page - 1) * 9);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listProducts.add(new Products(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(6)), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return listProducts;
    }
    public ArrayList<Products> getAllProduct( int page) {
        ArrayList<Products> listProducts = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName,p.CategoryID,p.UnitPrice,p.UnitsInStock,c.CategoryName from Products p ,Categories c\n"
                    + "where p.CategoryID = c.CategoryID \n"
                    
                    + "order by p.ProductID\n"
                    + "offset ? rows fetch next 9 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            stm.setInt(1, (page - 1) * 9);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listProducts.add(new Products(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(6)), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return listProducts;
    }
    public ArrayList<Products> getProducts(ArrayList<Integer> productIds) {
        String productsStr = productIds.toString();
        productsStr = '(' + productsStr.substring(1);
        productsStr = productsStr.substring(0, productsStr.length() - 1) + ')';
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName,p.CategoryID,p.UnitPrice,p.UnitsInStock,c.CategoryName from Products p ,Categories c\n"
                    + "where p.CategoryID = c.CategoryID \n"
                    + "and P.ProductId in " + productsStr;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Products(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(6)), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Products getProductById(int pid) {
        try {
            String sql = "select p.ProductID, p.ProductName,p.CategoryID,p.UnitPrice,p.UnitsInStock,c.CategoryName from Products p ,Categories c\n"
                    + "where p.ProductID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Products(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(6)), rs.getString(4), rs.getInt(5));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void updateQuantity(int quantity , int pid) {

        try {
            String sql = "update Products  \n"
                    + "set UnitsInStock = UnitsInStock - ?\n"
                    + "where  ProductID =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, pid);
            stm.execute();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        ArrayList<Products> list = new ArrayList<>();
        ProductDAO dao = new ProductDAO();
        list = dao.getProductByCid(1, 1);
        System.out.println(list.get(1).getName());
    }
}
