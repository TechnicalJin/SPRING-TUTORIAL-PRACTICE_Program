package com.hibernate.NativeSQL;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Insert Sample Employees
        System.out.println("\nInserting Sample Employees...");
        employeeDAO.addEmployee("John Doe", 1);
        employeeDAO.addEmployee("Jane Smith", 1);
        employeeDAO.addEmployee("Alice Brown", 2);
        employeeDAO.addEmployee("Bob Johnson", 2);

        // Fetch Employees by Department
        System.out.println("\nMapping Native Queries to Entities...");
        employeeDAO.getEmployeesByDepartment(1);

        System.out.println("\nUsing @NamedNativeQuery...");
        employeeDAO.getEmployeesUsingNamedQuery(1);

        System.out.println("\nUsing ResultSet Mapping...");
        employeeDAO.getEmployeesWithCustomMapping(1);

        System.out.println("\nCounting Employees...");
        employeeDAO.countEmployees();

        System.out.println("\nFetching Partial Columns...");
        employeeDAO.getEmployeeNamesByDept(1);
    }
}