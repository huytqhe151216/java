
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

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Order;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext {

    public int InsertOrder(Order order) {
        try {
            String sql = "insert into Order(OrderDate, RequiredDate, Shipvia, ShipName, ShipAddress) values (getdate(), ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, Date.valueOf(order.getRequiredDate()));
            stm.setString(3, order.getShipName());
            stm.setString(4, order.getShipAddress());
            stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }
        } catch (NumberFormatException | SQLException e) {
        }
        return -1;
    }
}
