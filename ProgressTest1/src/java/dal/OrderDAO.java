
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
import model.Shipper;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext {

    public int InsertOrderInfo(String customerId,String requireDate, int shipVia, String shipAddr, String potalCode, String country) {
        try {
            String sql = "insert into Orders(CustomerID, RequiredDate,ShipVia,ShipAddress, ShipPostalCode,ShipCountry , OrderDate) \n"
                    + "values(?,?,?,?,?,?,getDate())";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, customerId);
            stm.setString(2, requireDate);
            stm.setInt(3, shipVia);
            stm.setString(4, shipAddr);            
            stm.setString(5, potalCode);
            stm.setString(6, country);
            
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("loi do em:"+e);
        }
        return -1;
    }
    public ArrayList<Shipper> getAllShipper(){
        ArrayList<Shipper> list = new ArrayList<>();
        try {
            String sql= "select * from Shippers";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Shipper(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
