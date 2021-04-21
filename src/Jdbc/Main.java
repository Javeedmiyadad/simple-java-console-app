package Jdbc;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        System.out.println("please select any options");
        System.out.println("************************");
        System.out.println("press 1 : Insert ");
        System.out.println("press 2 : update ");
        System.out.println("press 3 : delete ");
        System.out.println("press 4 : get ");
        System.out.println("press 5 : get by id ");
        System.out.println("************************");

        int option = scanner.nextInt();
        switch (option) {
            case 1: {
                insert();
                break;
            }
            case 2: {
                update();
                break;
            }
            case 3: {
                delete();
                break;
            }
            case 4: {
                get();
                break;
            }
            case 5: {
                GetbyId();
                break;
            }

            default: {
                System.out.println("please select any one");
            }

        }
    }

    private static void insert() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter empId : ");
        int id = sc.nextInt();

        System.out.print("Enter Name : ");
        String name = sc.next();

        System.out.print("Enter Email : ");
        String email = sc.next();

        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Employee employee = new Employee(id, name, email);
        dao.addEmployee(employee);

    }

    private static void update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter id to be updated:");
        int id = sc.nextInt();

        System.out.println("enter name and email:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Email: ");
        String email = sc.next();

        Employee employee = new Employee(id, name, email);
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        dao.updateEmployee(employee);

    }

    private static void delete() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Id to be delete : ");
        int id = scanner.nextInt();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Employee employee = new Employee();
        dao.deleteEmployee(id);
    }

    private static void get() throws SQLException {
        EmployeeDao dao1 = EmployeeDaoFactory.getEmployeeDao();
        List<Employee> list = dao1.getEmployees();
        for (Employee emp : list) {
            System.out.println(emp.toString());
        }
    }

    private static void GetbyId() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id to get employee details : ");
        int id = scanner.nextInt();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Employee employee = dao.getEmployeeById(id);
        System.out.println(employee.toString());

    }
}




