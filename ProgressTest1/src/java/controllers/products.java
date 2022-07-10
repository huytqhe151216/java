
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
import dal.CustomerDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Products;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "products", urlPatterns = {"/products"})
public class products extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     *    * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Category> listCategory = new ArrayList<>();
        ArrayList<Products> listProducts = new ArrayList<>();
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        int totalProductByCid = 0;
        int numberPage = 0;
        int currentPage = 1;
        int cid = 1;
        try {
            listCategory = categoryDAO.getAllCategories();
        } catch (Exception e) {
        }
        request.setAttribute("listCategory", listCategory);

        if (request.getParameter("cid") != null) {
            cid = Integer.parseInt(request.getParameter("cid"));
            try {
                totalProductByCid = productDAO.countAllProductByCategoryId(cid);
                numberPage = (totalProductByCid % 9 == 0) ? (totalProductByCid / 9) : (totalProductByCid / 9 + 1);
                if (request.getParameter("page") != null) {
                    currentPage = Integer.parseInt(request.getParameter("page"));
                }
                listProducts = productDAO.getProductByCid(cid, currentPage);
            } catch (NumberFormatException e) {
            }
        } else {
            try {
                totalProductByCid = productDAO.countAllProduct();
                numberPage = (totalProductByCid % 9 == 0) ? (totalProductByCid / 9) : (totalProductByCid / 9 + 1);
                if (request.getParameter("page") != null) {
                    currentPage = Integer.parseInt(request.getParameter("page"));
                }
                listProducts = productDAO.getAllProduct(currentPage);
            } catch (NumberFormatException e) {
            }
        }

        request.setAttribute("numberPage", numberPage);
        request.setAttribute("cid", cid);
        request.setAttribute("listProducts", listProducts);

        request.getRequestDispatcher("products.jsp").forward(request, response);
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
