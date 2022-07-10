/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;

/**
 *
 * @author lephu
 */
public class EmployeeDAO extends DBContext {

    public Employee getEmployeeById(int id) {
        Employee em = new Employee();
        try {
            String sql = "select * from Employee e, Department d\n"
                    + "where e.Department = d.id and e.id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                em = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5));
                em.addDepartment(rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException e) {
        }
        return em;
    }

    public ArrayList<Employee> getAllEmployeesByDeptId(int deptId, int pageIndexByDepId) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "select e.*, d.name as [departmentname] from Employee e, Department d\n"
                    + "where e.Department=d.Id and e.Department= ?\n"
                    + "order by e.Id\n"
                    + "offset ? rows fetch next 20 rows only";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, deptId);
            stm.setInt(2, (pageIndexByDepId - 1) * 20);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Employee e = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("sex"),
                        rs.getString("position"));
                e.addDepartment(rs.getInt("department"), rs.getString("departmentname"));
                list.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void addEmployee(Employee e) {
        try {
            String sql = "insert into Employee(name, sex, dob, position, department)"
                    + "values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, e.getName());
            stm.setString(2, e.getSex());
            stm.setDate(3, Date.valueOf(e.getDob()));
            stm.setString(4, e.getPosition());
            stm.setInt(5, e.getDepartment().getId());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteEmployeeById(int employeeID) {
        try {
            String sql = "delete from Employee where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, employeeID);
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean updateEmployee(Employee em) {
        try {
            String sql = "update Employee\n"
                    + "set Name=?, Dob=?, Sex=?, Position=?, Department=?\n"
                    + "where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, em.getName());
            stm.setDate(2, Date.valueOf(em.getDob()));
            stm.setString(3, em.getSex());
            stm.setString(4, em.getPosition());
            stm.setInt(5, em.getDepartment().getId());
            stm.setInt(6, em.getId());
            stm.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            String sql = "select e.Id, e.Name, e.Dob,e.Sex, e.Position, e.Department, d.Name from Employee e, Department d\n"
                    + "where e.Department = d.Id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee em = new Employee(rs.getInt(1), rs.getString(2), rs.getDate("dob").toLocalDate(), rs.getString(4), rs.getString(5));
                em.addDepartment(rs.getInt(6), rs.getString(7));
                list.add(em);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Employee> getEmployeeByFilter(String id, String name, String gender, String from, String to, String position) {
        ArrayList<Employee> listE = new ArrayList<>();
        String date = "";
        try {
            if (from.isEmpty() && to.isEmpty()) {
                date = "";
            } else if (from.isEmpty() && !to.isEmpty()) {
                date = "and e.Dob <= '" + Date.valueOf(to) + "'";
            } else if (!from.isEmpty() && to.isEmpty()) {
                date = "and e.Dob >= '" + Date.valueOf(from) + "'";
            } else {
                date = "and e.Dob between" + Date.valueOf(from) + " and " + Date.valueOf(to);
            }
            String sql = "select * from Employee e, Department d\n"
                    + "where e.Name like ?\n"
                    + "and d.id = e.Department\n"
                    + "and e.Sex like ?\n"
                    + "and d.id like ?\n"
                    + date
                    + " and e.Position like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            stm.setString(2, gender + "%");
            stm.setString(3, id.isEmpty() ? "%" : "%" + id + "%");
            stm.setString(4, "%" + position + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee em = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5));
                em.addDepartment(rs.getInt(7), rs.getString(8));
                listE.add(em);
            }
        } catch (SQLException e) {

        }
        return listE;
    }

    public ArrayList<String> getDistinctPosition() {
        ArrayList<String> po = new ArrayList<>();
        try {
            String sql = "select distinct Position from Employee";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                po.add(rs.getString(1));
            }
        } catch (SQLException e) {
        }
        return po;
    }

    public int countAllEmployees() {
        String sql = "select COUNT(*) from Employee";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public ArrayList<Employee> pagingEmployees(int depId, int pageIndex) {
        ArrayList<Employee> list = new ArrayList<>();
        String sql = "select * from Employee  e , Department d\n"
                + "where e.Department=d.Id\n";
        if (depId != 0) {
            sql += "and e.Department=?\n";
        }
        sql += "order by e.Id\n"
                + "offset ? rows  fetch next 20 rows only";
        try {

            PreparedStatement stm = connection.prepareStatement(sql);
            if (depId != 0) {
                stm.setInt(1, depId);
                stm.setInt(2, (pageIndex - 1) * 20);
            } else {
                stm.setInt(1, (pageIndex - 1) * 20);
            }
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Employee em = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5));
                em.addDepartment(rs.getInt(7), rs.getString(8));
                
                list.add(em);

            }
        } catch (SQLException e) {
        }
        return list;
    }
//    public ArrayList<Employee> getEmployees(int currentPage, int numberPerPage) {
//        ArrayList<Employee> em = new ArrayList<>();
//        try {
//            String sql = "select * from Employee, Department\n"
//                    + "where Employee.Department = Department.Id order by Employee.Id\n"
//                    + "offset (?-1)*? rows\n"
//                    + "fetch next ? rows only";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, currentPage);
//            stm.setInt(2, numberPerPage);
//            stm.setInt(3, numberPerPage);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                Employee emp = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getString(4), rs.getString(5));
//                emp.addDepartment(rs.getInt(7), rs.getString(8));
//                em.add(emp);
//            }
//        } catch (SQLException e) {
//        }
//        return em;
//    }

    public int countEmployeesByDepId(int depID) {
        String sql = "select count(*) from Employee e\n"
                + "where e.Department=?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, depID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public int getNumberOfEmployee(int deptId) {
        try {
            String sql = "select count(*) [numEmp] from Employee e ";
            if (deptId != 0) {
                sql += "where e.Department = ?";
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            if (deptId != 0) {
                stm.setInt(1, deptId);
            }
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getInt("numEmp");
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        System.out.println("abe");
        ArrayList<Employee> list = dao.getAllEmployeesByDeptId(1, 1);
        int x = dao.countEmployeesByDepId(1);
        for (Employee employee : list) {
            System.out.println(employee.getName());
        }
    }
}
