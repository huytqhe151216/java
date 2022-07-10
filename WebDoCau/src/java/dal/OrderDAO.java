
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
import java.util.Date;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author ADMIN
 */
public class OrderDAO extends DBContext {

    public int insertOrderInfo(int customerId, String name, String phone, String address) {
        try {
            String sql = "insert into Orders values(?,getDate(), ? , ? , ?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, customerId);
            stm.setString(2, name);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public void insertOrderStattus(int orderId) {
        try {
            String sql = "insert into OrderStatus values(? , 0)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateStatus(int orderId) {
        try {
            String sql = "update OrderStatus \n"
                    + "set orderStatus = 1\n"
                    + "where orderId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Order> getOrderPending() {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        ArrayList<Order> listOrder = new ArrayList<>();
        try {
            String sql = "select * from Orders o , OrderStatus os , Customer  c\n"
                    + "where o.orderId =os.orderId and os.orderStatus=0 and c.customerId = o.customerId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listOrder.add(new Order(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listOrder;
    }
    public static void main(String[] args) {
        ArrayList<Order> listoder = new ArrayList<>();
        OrderDAO  orderDAO= new OrderDAO();
        listoder =orderDAO.getOrderPending();
        System.out.println(listoder.size());
    }
}
