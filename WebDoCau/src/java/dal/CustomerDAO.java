    
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
import java.util.ArrayList;
import models.Customer;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO extends DBContext {

    public Customer getCustomer(String usernam, String password) {
        try {
            String sql = "select * from Customer c\n"
                    + "where c.username = ? and c.password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, usernam);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Customer getCustomer(int id) {
        try {
            String sql = "select * from Customer c\n"
                    + "where c.customerId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public boolean isUsernameExist(String username) {

        try {
            String sql = "select * from Customer c\n"
                    + "where c.username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString(6).equals(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }

        return false;
    }

    public void addCustomer(String name, String phone, String addr, String username, String pass) {
        try {
            String sql = "insert into Customer values(?,?,?,0,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            stm.setString(2, phone);
            stm.setString(3, addr);
            stm.setString(4, username);
            stm.setString(5, pass);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCustomer(int id, String name, String add, String phone) {
        try {
            String sql = "update Customer \n"
                    + "set customerName =? , customerPhone =? , customerAddress =?\n"
                    + "where customerId =?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, name);
            stm.setString(2, phone);
            stm.setString(3, add);
            stm.setInt(4, id);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        Customer c = new Customer();
        c = dao.getCustomer("admin", "1");
        System.out.println(c.isIsAdmin());
    }
}
