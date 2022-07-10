
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

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Customer;
import models.Product;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "modifyProduct", urlPatterns = {"/modifyProduct"})
public class modifyProduct extends HttpServlet {

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
        
        request.setCharacterEncoding("UTF-8");
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
        request.getRequestDispatcher("modifyproduct.jsp").forward(request, response);
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
        Product p = new Product();
         request.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        p=productDAO.getProductById(pid);
        request.setAttribute("p", p);
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory = categoryDAO.getAllCategory();
        request.setAttribute("listCategory", listCategory);
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
        String mess = "";
         request.setCharacterEncoding("UTF-8");
        CategoryDAO categoryDAO = new CategoryDAO();
        ArrayList<Category> listCategory = new ArrayList<>();
        listCategory = categoryDAO.getAllCategory();
        request.setAttribute("listCategory", listCategory);
        try {
             
            int pid=Integer.parseInt(request.getParameter("pid"));
            int price = Integer.parseInt(request.getParameter("price"));
            int unitInStock =  Integer.parseInt(request.getParameter("unitinstock"));
            int cid = Integer.parseInt(request.getParameter("cid"));
            String name = request.getParameter("name");
            String description = request.getParameter("depscription");
            ProductDAO productDAO = new ProductDAO();
            Product p =productDAO.getProductById(pid);
            request.setAttribute("p", p);
            productDAO.updateProduct(pid, price, unitInStock, name, description, cid);
            mess="Sửa thành công";
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        request.setAttribute("mess", mess);
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
