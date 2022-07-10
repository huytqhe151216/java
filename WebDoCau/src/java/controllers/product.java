
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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Product;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "product", urlPatterns = {"/product"})
public class product extends HttpServlet {

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
        ArrayList<Category> listCategory = new ArrayList<>();
        ArrayList<Product> listProduct = new ArrayList<>();
        CategoryDAO categoryDAO = new CategoryDAO();
        ProductDAO productDAO = new ProductDAO();
        String currrentURL = request.getRequestURI() + "?" + request.getQueryString();
        HttpSession session = request.getSession();
        session.setAttribute("localPage", "product");
        session.setAttribute("currentURL", currrentURL);
        Category c = new Category();
        int currentPage = 1;
        int totalpage = 0;
        int cid = -1;
        String name = "";
        if (request.getParameter("name") != null) {
            name = request.getParameter("name");
        }
        String price[] = null;
        try {
            if (request.getParameter("price") == null) {
                price = "0-10000000".split("-");
            } else {
                price = request.getParameter("price").split("-");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        boolean sortByPrice = true;
        
        if (request.getParameter("sort") != null) {
            if(request.getParameter("sort").equals("0")){
                sortByPrice = false;
            }
        }
        if (request.getParameter("cid") != null && request.getParameter("cid") != "") {
            cid = Integer.parseInt(request.getParameter("cid"));
            
            c = categoryDAO.getCategoryByCid(cid);
            request.setAttribute("c", c);
            request.setAttribute("cid", cid);
            try {
//                int numberProduct = productDAO.countProductByCategoryId(cid);
                int numberProduct = productDAO.countProductByAll(cid, name, Integer.parseInt(price[0]), Integer.parseInt(price[1]));
                totalpage = (numberProduct % 12 == 0) ? (numberProduct / 12) : (numberProduct / 12 + 1);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            try {
                if (request.getParameter("page") != null) {
                    currentPage = Integer.parseInt(request.getParameter("page"));
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            try {
//                listProduct = productDAO.getProductByCategory(cid, currentPage);
                listProduct = productDAO.getProductByAll(name, Integer.parseInt(price[0]), Integer.parseInt(price[1]), sortByPrice, currentPage, cid);
                System.out.println(listProduct.size());
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } else {

            try {
//                int numberProduct = productDAO.countAllProducts();
                int numberProduct = productDAO.countProductByAll(-1, name, Integer.parseInt(price[0]), Integer.parseInt(price[1]));
                totalpage = (numberProduct % 12 == 0) ? (numberProduct / 12) : (numberProduct / 12 + 1);
            } catch (NumberFormatException e) {
            }
            try {
                if (request.getParameter("page") != null) {
                    currentPage = Integer.parseInt(request.getParameter("page"));
                }
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            try {
//                listProduct = productDAO.getAllProducts(currentPage);
                listProduct = productDAO.getProductByAll(name, Integer.parseInt(price[0]), Integer.parseInt(price[1]), sortByPrice, currentPage, -1);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }

        try {
            listCategory = categoryDAO.getAllCategory();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (request.getParameter("price")==null) {
            request.setAttribute("price", "0-10000000");
        }else{
            request.setAttribute("price", request.getParameter("price"));
        }
        request.setAttribute("name", name);
        request.setAttribute("sort", sortByPrice);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("listProduct", listProduct);

        request.setAttribute("totalPage", totalpage);
        request.getRequestDispatcher("product.jsp").forward(request, response);
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
