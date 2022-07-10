
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import models.Category;
import models.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getProductByCategory(int categoryId, int currentPage) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "select * from Product p , Category c\n"
                    + "where p.categoryId=c.CategoryId and p.categoryId =?\n"
                    + "order by p.productId\n"
                    + "offset ? row fetch next 12 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);
            stm.setInt(2, (currentPage - 1) * 12);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(8))));
            }
        } catch (SQLException e) {
        }
        return listProduct;
    }

    public ArrayList<Product> getAllProducts(int currentPage) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            String sql = "select * from Product p , Category c\n"
                    + "          where p.categoryId =c.CategoryId         \n"
                    + "                    order by p.productId\n"
                    + "                    offset ? row fetch next 12 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, (currentPage - 1) * 12);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listProduct.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(8))));
            }
        } catch (SQLException e) {
        }
        return listProduct;
    }

    public int countProductByCategoryId(int categoryId) {
        try {
            String sql = "select count(*) as count from Product p\n"
                    + "where p.categoryId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return -1;
    }

    public int countAllProducts() {
        try {
            String sql = "select count(*) as count from Product p\n";

            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return -1;
    }

    public int countProductByAll(int cid, String name, int price1, int price2) {
        try {
            if (cid == -1) {
                String sql = "select count(*) from Product p , Category c\n"
                        + "where p.categoryId = c.CategoryId\n"
                        + "and p.productName like ? \n"
                        + " and p.productPrice between ? and ?";

                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setNString(1, "%" + name + "%");
                stm.setInt(2, price1);
                stm.setInt(3, price2);

                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {
                    return rs.getInt(1);
                }
            } else {
                String sql = "select count(*) from Product p , Category c\n"
                        + "where p.categoryId = c.CategoryId\n"
                        + "and c.CategoryId= ? \n"
                        + "and p.productName like ? \n"
                        + " and p.productPrice between ? and ?";

                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, cid);
                stm.setNString(2, "%" + name + "%");
                stm.setInt(3, price1);
                stm.setInt(4, price2);

                ResultSet rs = stm.executeQuery();

                while (rs.next()) {

                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println();
        }
        return -1;
    }

    public ArrayList<Product> getNewestProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String sql = "select top(9) p.*,c.* from Product p ,Category c\n"
                    + "where p.categoryId =c.CategoryId\n"
                    + "                    order by p.productId desc";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(8))));
            }
        } catch (SQLException e) {
        }
        return list;

    }

    public ArrayList<Product> getProductByAll(String name, int price1, int price2, boolean sortByPrice, int page, int cid) {
// sort =true tang
//sory = false giam
        ArrayList<Product> list = new ArrayList<>();
        try {
//            String sql1 = "select * from Product p , Category c\n"
//                    + "where p.categoryId = c.CategoryId\n"
//                    + "and p.productName like N'%cần%' \n"
//                    + " and p.productPrice between 0 and 1000000\n"
//                    + " order by p.productPrice \n"
//                    + " offset 1 row fetch next 4 rows only";

            if (cid == -1) {
                String sql = "select  * from Product p ,Category c\n"
                        + "where p.categoryId =c.CategoryId\n"
                        + "and p.productName like ? \n"
                        + " and p.productPrice between ? and ?\n";
                if (sortByPrice) {
                    sql += " order by p.productPrice \n";
                } else {
                    sql += " order by p.productPrice desc \n";
                }
                sql += " offset ? row fetch next 12 rows only";

                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setNString(1, "%" + name + "%");
                stm.setInt(2, price1);
                stm.setInt(3, price2);
                stm.setInt(4, (page - 1) * 12);

                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(8))));
                }
            } else {
                String sql = "select  * from Product p ,Category c\n"
                        + "where p.categoryId =c.CategoryId\n"
                        + " and c.CategoryId=? \n"
                        + "and p.productName like ? \n"
                        + " and p.productPrice between ? and ?\n";
                if (sortByPrice) {
                    sql += " order by p.productPrice \n";
                } else {
                    sql += " order by p.productPrice desc \n";
                }
                sql += " offset ? row fetch next 12 rows only";
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setInt(1, cid);
                stm.setNString(2, "%" + name + "%");
                stm.setInt(3, price1);
                stm.setInt(4, price2);
                stm.setInt(5, (page - 1) * 12);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(8))));
                }
            }

        } catch (SQLException e) {
        }
        return list;

    }

    public Product getProductById(int pid) {
        try {
            String sql = "select * from Product p , Category c\n"
                    + "where p.productId =? and  p.categoryId =c.CategoryId";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), new Category(rs.getInt(7), rs.getString(9)));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<String> getProductImgById(int id) {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "select * from productIMG img \n"
                    + "where img.productId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return list;

    }

    public void updateQuantity(int pid, int quantity) {
        try {
            String sql = "update Product\n"
                    + "set unitInStock = unitInStock- ?\n"
                    + "where productId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, quantity);
            stm.setInt(2, pid);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int pid ,int price,int unitInStock, String name,String description, int cid ) {
        try {
            String sql = " update Product\n"
                    + " set productPrice = ? , unitInStock =? , productName = ? , productDescription =? , categoryId =?\n"
                    + " where productId =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, price);
            stm.setInt(2, unitInStock);
            stm.setNString(3, name);
            stm.setNString(4, description);
            stm.setInt(5, cid);
            stm.setInt(6, pid);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int addProduct(String name, String description, int price, String quantityperUnit, int unitInStock, int categoryId) {
        try {
            String sql = "insert into Product values(?, ?, ? ,? , ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setNString(1, name);
            stm.setNString(2, description);
            stm.setInt(3, price);
            stm.setNString(4, quantityperUnit);
            stm.setInt(5, unitInStock);
            stm.setInt(6, categoryId);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public void insertIMG(int pid, String img1, String img2, String img3) {
        try {
            String sql = "insert into productIMG values(?, ?), (?, ?) ,(?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            stm.setString(2, img1);
            stm.setInt(3, pid);
            stm.setString(4, img2);
            stm.setInt(5, pid);
            stm.setString(6, img3);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = new ArrayList<>();
        list = dao.getProductByAll("cần", 0, 10000000, true, 1, -1);
        System.out.println(list.size());
    }
}
