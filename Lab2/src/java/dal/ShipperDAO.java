
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
import models.Shipper;

/**
 *
 * @author ADMIN
 */
public class ShipperDAO extends DBContext{
     public ArrayList<Shipper> getAllShippers() {
        ArrayList<Shipper> list = new ArrayList<>();
        try {
            String sql = "Select ShipperID, CompanyName from Shippers";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Shipper s = new Shipper(
                        rs.getInt("ShipperID"),
                        rs.getString("CompanyName")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
}
