
/*
 * Copyright(C) 2005, FPT university
 * ...
 * ...
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2018-09-10      1.0                 HuyTQ           First Implement
 */
package controllers;

import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Cart;
import models.Customer;
import models.Product;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "order", urlPatterns = {"/order"})
public class order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Customer customers = (Customer) session.getAttribute("isLogin");

        request.setAttribute("customer", customers);
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customers = (Customer) session.getAttribute("isLogin");
        OrderDAO orderDAO = new OrderDAO();
        String mess = "";

        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        Cart cart = new Cart();
        if (session.getAttribute("cart") != null) {
            cart = (Cart) session.getAttribute("cart");
            HashMap<Product, Integer> items = (HashMap<Product, Integer>) cart.getItems();

            try {
                int x = 0;
                if (customers == null) {
                    x = orderDAO.insertOrderInfo(4, request.getParameter("name"), request.getParameter("phone"), request.getParameter("address"));
                } else {
                    x = orderDAO.insertOrderInfo(customers.getId(), request.getParameter("name"), request.getParameter("phone"), request.getParameter("address"));

                }
                orderDAO.insertOrderStattus(x);
                for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                    Product key = entry.getKey();
                    Integer value = entry.getValue();
                    orderDetailDAO.insertOrderDetail(x, key.getId(), value);
                    ProductDAO productDAO = new ProductDAO();
                    productDAO.updateQuantity(key.getId(), value);
                }
                session.removeAttribute("cart");
                session.setAttribute("total", 0);
                mess = "Đặt hàng thành công. Chúng tôi sẽ gọi điện xác nhận đơn hàng qua số điện thoại "+ request.getParameter("phone");
            } catch (Exception e) {

            }

            request.setAttribute("mess", mess);

        }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
