/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dal.DepartmentDAO;
import dal.EmployeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Department;
import models.Employee;

/**
 *
 * @author lephu
 */
@WebServlet(name = "employees", urlPatterns = {"/employees"})
public class employees extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int depId = 0;
    private int page = 1;
    private int totalPage = 10;

    private void buildPager(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("endPage", totalPage);
        request.setAttribute("curPage", page);
        String curUrl = request.getRequestURL().toString() + "?";
        if (depId != 0) {
            curUrl += "did=" + depId + "&";
        }
        request.setAttribute("curUrl", curUrl);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nextpage = "employees.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(nextpage);
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
        ArrayList<Employee> emplist = new ArrayList<>();
        EmployeeDAO dao = new EmployeeDAO();
        DepartmentDAO d = new DepartmentDAO();
        ArrayList<String> po = new ArrayList<>();
        ArrayList<Department> listD = new ArrayList<>();
        int pageIndex = request.getParameter("pageIndex") != null ? Integer.parseInt(request.getParameter("pageIndex")) : 1;
        int endPage = 0;
        int departmentId = 0;
        try {
            if (request.getParameter("did") != null) {
                depId = Integer.parseInt(request.getParameter("did"));
            }
            int count = dao.getNumberOfEmployee(depId);
            System.out.println(count);
            endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }
            listD = d.getAllDepartments();
            po = dao.getDistinctPosition();
            emplist = dao.pagingEmployees(depId, pageIndex);

        } catch (NumberFormatException e) {
        }
        totalPage = endPage;
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("endP", endPage);
        request.setAttribute("listP", po);
        request.setAttribute("listD", listD);
        request.setAttribute("emps", emplist);
        buildPager(request, response);
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
        ArrayList<Employee> emplist = new ArrayList<>();
        EmployeeDAO dao = new EmployeeDAO();
        DepartmentDAO d = new DepartmentDAO();
        ArrayList<String> po = new ArrayList<>();
        ArrayList<Department> listD = new ArrayList<>();
        try {
            listD = d.getAllDepartments();
            po = dao.getDistinctPosition();
            String name = request.getParameter("name");
            String dateFrom = request.getParameter("dobFrom");
            String dateTo = request.getParameter("dobTo");
            String gender = request.getParameter("gender");
            String position = request.getParameter("position");
            String departmentid = request.getParameter("department");
            emplist = dao.getEmployeeByFilter(departmentid, name, gender, dateFrom, dateTo, position);
        } catch (Exception e) {
        }
        request.setAttribute("listP", po);
        request.setAttribute("listD", listD);
        request.setAttribute("emps", emplist);
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
