
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

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "student", urlPatterns = {"/student"})
public class student extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentjsp.jsp");
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
        request.setAttribute("fName", "");
        request.setAttribute("lName", "");
        request.setAttribute("gender", "");
        request.setAttribute("DOB", "");
        request.setAttribute("major", "");
        request.setAttribute("cb1", "");
        request.setAttribute("cb2", "");
        request.setAttribute("mess", "");
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
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String DOB = request.getParameter("DOB");
        String cb1 = request.getParameter("cb1");
        String cb2 = request.getParameter("cb2");
        request.setAttribute("fName", fName);

        request.setAttribute("lName", lName);
        request.setAttribute("gender", gender);
        request.setAttribute("DOB", DOB);
        request.setAttribute("major", major);
        request.setAttribute("cb1", cb1);
        request.setAttribute("cb2", cb2);

        mess = "Student:"+fName+" "+lName+" "+gender+" " +major+" "+DOB+" ";
        if(cb1 == null && cb2 == null){
            request.setAttribute("cb1", "");
            request.setAttribute("cb2", "");
        } else if(cb1 == null && cb2!=null){
            request.setAttribute("cb2", cb2);
            request.setAttribute("cb1", "");
            mess= mess+" " + cb2;
        } else if(cb2 == null && cb1!=null){
            request.setAttribute("cb1", cb1);
            request.setAttribute("cb2", "");
            mess= mess+ " " + cb1;
        } else {
            request.setAttribute("cb1", cb1);
            request.setAttribute("cb2", cb2);
            mess= mess + cb1 + ", " + cb2;
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
