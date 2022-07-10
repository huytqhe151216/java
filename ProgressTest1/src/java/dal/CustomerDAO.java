
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
import model.Customers;

/**
 *
 * @author ADMIN
 */
public class CustomerDAO extends DBContext{

    public Customers getCustomer(String userName, String password) {
        
        try {
            String sql = "select c.CustomerID, c.CompanyName, c.Address,c.City,c.Region,c.PostalCode,c.Country,c.username  from Customers c\n"
                    + "where c.username = ? and c.password=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            stm.setString(2, password);
            ResultSet rs  = stm.executeQuery();
            while (rs.next()) {
                 Customers customers = new Customers(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7), rs.getString(8));
                 return customers;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        Customers c = new Customers();
        c= dao.getCustomer("huy", "123");
        System.out.println(c.getUserName());
    }
}
