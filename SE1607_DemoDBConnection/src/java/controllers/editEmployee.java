
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

import dal.DepartmentDAO;
import dal.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Department;
import models.Employee;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "editEmployee", urlPatterns = {"/editEmployee"})
public class editEmployee extends HttpServlet {

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

        request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
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
        System.out.println("da chay1");
        EmployeeDAO dao = new EmployeeDAO();
        DepartmentDAO daoD = new DepartmentDAO();
        Employee em = new Employee();
        ArrayList<Department> dp = new ArrayList<>();
        try {
            em = dao.getEmployeeById(Integer.parseInt(request.getParameter("eid")));
            dp = daoD.getAllDepartments();
            System.out.println("da chay2");
            System.out.println(dp);
            System.out.println(em);
        } catch (NumberFormatException e) {
        }
        request.setAttribute("employee", em);
        request.setAttribute("listD", dp);
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
        EmployeeDAO dao = new EmployeeDAO();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Date dob = Date.valueOf(request.getParameter("dob"));
            String gender = request.getParameter("gender");
            String position = request.getParameter("position");
            int departmentidold = Integer.parseInt(request.getParameter("departmentidold"));
            Employee em = new Employee(id, name, dob.toLocalDate(), gender, position);
            em.addDepartment(departmentidold, "");
            dao.updateEmployee(em);
            response.sendRedirect("./employees?did=" + departmentidold);
        } catch (IOException | NumberFormatException e) {
        }
//        processRequest(request, response);
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
