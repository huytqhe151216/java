
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

import dal.CustomerDAO;
import dal.OrderDAO;
import dal.OrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Customer;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "managementShop", urlPatterns = {"/managementShop"})
public class managementShop extends HttpServlet {

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
        if (session.getAttribute("isLogin") == null) {
            response.sendRedirect("WebDoCau");
            return;
        } else {
            Customer customers = (Customer) session.getAttribute("isLogin");
            if (customers.isIsAdmin() == false) {
                response.sendRedirect("WebDoCau");
                return;
            } else {

            }
        }
        request.getRequestDispatcher("managementShop.jsp").forward(request, response);
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
        OrderDAO orderDAO = new OrderDAO();
        Customer customer  = new Customer();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        ArrayList<OrderDetail> listOrderDetail =  new ArrayList<>();
        ArrayList<Order> listOrderPending = new ArrayList<>();
        listOrderPending = orderDAO.getOrderPending();
        System.out.println(Arrays.toString(listOrderPending.toArray()));
        for (Order order : listOrderPending) {
            System.out.println("id="+order.getCustomerById().getName());
        }
        CustomerDAO customerDAO = new CustomerDAO();
        
        request.setAttribute("listOrderPending", listOrderPending);
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
