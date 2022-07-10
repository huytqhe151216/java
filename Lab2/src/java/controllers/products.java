
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Category;
import models.Product;

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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void loadCategory(HttpServletRequest request, HttpServletResponse response1){
        CategoryDAO catDAO = new CategoryDAO();
        ArrayList<Category> categories = catDAO.getAllCategoryies();
        request.setAttribute("cats", categories);
    }
    private void loadProduct(HttpServletRequest request, HttpServletResponse response){
        ProductDAO productDAO = new ProductDAO();
        int catID=0;
        int pageNo = 1;
        int numberPage = 1;
        int rowNumber ;
        try {
            pageNo = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException e) {
        }
        ArrayList<Product> products = new ArrayList<>();
        if (request.getParameter("cid")!=null) {
            catID = Integer.parseInt(request.getParameter("cid"));
            rowNumber = productDAO.getNumberOfProductsByCid(catID);
            request.setAttribute("cid", catID);
        } else {
            rowNumber = productDAO.getNumberOfProducts();
            products = productDAO.getProductsByPage(pageNo);
            request.setAttribute("cid", 0);
        }
        numberPage = (rowNumber % 8 == 0 ? (rowNumber / 8) : ((rowNumber / 8) + 1));
        request.setAttribute("page", pageNo);
        request.setAttribute("num", numberPage);
        request.setAttribute("listProduct", products);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        loadCategory(request, response);
        loadProduct(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
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
