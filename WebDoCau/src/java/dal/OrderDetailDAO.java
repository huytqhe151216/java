
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
import models.Order;
import models.OrderDetail;
import models.Product;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO extends DBContext {

    public void insertOrderDetail(int orderID, int pid, int quantity) {
        try {
            String sql = "insert into OrderDetail values(?, ?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderID);
            stm.setInt(2, pid);
            stm.setInt(3, quantity);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Integer> getHistoryOrder(int customerId) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            String sql = "select * from OrderDetail od, Orders o , Customer c\n"
                    + "where od.OrderId =o.orderId and o.customerId = c.customerId \n"
                    + "and c.customerId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, customerId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (!list.contains(rs.getInt(2))) {
                    list.add(rs.getInt(2));
                }

            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<OrderDetail> viewOrderDetail(int orderId) {
        ArrayList<OrderDetail> listOrderDetail = new ArrayList<>();
        try {
            String sql = "select * from OrderDetail  od  ,Orders o\n"
                    + "where od.OrderId =? and od.OrderId = o.orderId";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, orderId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listOrderDetail.add(new OrderDetail(new Order(rs.getInt(1), rs.getInt(5)), rs.getInt(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listOrderDetail;
    }

    public static void main(String[] args) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        OrderDetailDAO OrderDetailDAO = new OrderDetailDAO();
        list = OrderDetailDAO.viewOrderDetail(5);
        System.out.println(list.size());
    }
}
