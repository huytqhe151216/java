
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO extends DBContext{
     public int InsertOrderDetail(int orderId, int productId, int quantity,double  unitPrice)
    {
        try{
            String sql = "insert into [Order Details](OrderId, ProductId, quantity, UnitPrice)"
                    + "values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            stm.setInt(2, productId);
            stm.setInt(3, quantity);
            stm.setDouble(4, unitPrice);
            stm.execute();
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
