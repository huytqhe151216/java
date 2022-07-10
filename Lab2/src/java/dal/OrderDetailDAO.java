
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
import models.OrderDetail;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO extends DBContext{
    public int InsertOrderDetail(OrderDetail orderD){
        try {
            String sql = "insert into [Order Details](OrderId, ProductId, quantity, UnitPrice) values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderD.getOrderId());
            stm.setInt(2, orderD.getProductId());
            stm.setInt(3, orderD.getQuantity());
            stm.setDouble(4, orderD.getUnitPrice());
            stm.executeUpdate();
        } catch (Exception e) {
        }
        return -1;
    }
}
