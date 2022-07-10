/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;

/**
 *
 * @author lephu
 */
public class DepartmentDAO extends DBContext {

    public ArrayList<Department> getAllDepartments() {
        ArrayList<Department> list = new ArrayList<>();
        try {
            String sql = "Select id, name from Department";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Department d = new Department(
                        rs.getInt("id"),
                        rs.getString("name"));
                list.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Employee> getAllEmployeeByDepartmentId(int id) {
        ArrayList<Employee> em = new ArrayList<>();
        try {
            String sql = "select * from Employee e, Department d\n"
                    + "where e.Department = d.id and d.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5));
                e.addDepartment(rs.getInt(7), rs.getString(8));
                em.add(e);
            }
        } catch (Exception e) {
        }
        return em;
    }
}
