package Jdbc;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static Statement statement = null;
    private Connection conn;

    public EmployeeDaoImpl() throws SQLException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }


    @Override
    public void addEmployee(Employee employee) {
        String sql = "insert into employee values(" + employee.getEmpId() + ",'" + employee.getName() + "', '" + employee.getEmail() + "')";
        int m = 0;
        try {
            m = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
        }
        if (m > 0) {
            System.out.println("Employee saved");
        } else {
            System.out.println("Not saved");
        }
    }

    @Override
    public void updateEmployee(Employee employee) {

        String sql = "update employee set name='" + employee.getName() + "', email='" + employee.getEmail() + "' where id=" + employee.getEmpId();
        int m = 0;
        try {
            m = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            // throwables.printStackTrace();
        }
        if (m > 0) {
            System.out.println("employee saved");
        } else {
            System.out.println("not saved");
        }

    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "delete from employee where Id = " + id;
        int m = 0;
        try {
            m = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            // throwables.printStackTrace();
        }
        if (m > 0) {
            System.out.println("employee saved");
        } else {
            System.out.println("not saved");
        }

    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "select * from employee where Id = " + id;
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int empId = rs.getInt("Id");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                employee = new Employee(empId, name, email);

            }
        } catch (SQLException throwables) {
            // throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "select * from employee";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int empid = rs.getInt("Id");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                Employee employee = new Employee(empid, name, email);
                list.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
