package com.hibernate.NativeSQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class EmployeeDAO {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    // A. Insert Employee Data into the Database
    public void addEmployee(String name, int departmentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee(name, departmentId);
        session.save(employee);

        transaction.commit();
        session.close();

        System.out.println("Employee Added: " + employee);
    }


    // B. Mapping Native Queries to Entities
    public void getEmployeesByDepartment(int deptId) {
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM nativesql WHERE department_id = :deptId";
        Query<Employee> query = session.createNativeQuery(sql, Employee.class);
        query.setParameter("deptId", deptId);
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);
        session.close();
    }

    // C. Using @NamedNativeQuery (Annotation-Based Approach)
    public void getEmployeesUsingNamedQuery(int deptId) {
        Session session = sessionFactory.openSession();
        Query<Employee> query = session.createNamedQuery("Employee.findByDepartment", Employee.class);
        query.setParameter("deptId", deptId); // Changed from positional to named parameter
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);
        session.close();
    }

    // D. Using Native Queries with ResultSet Mapping
    public void getEmployeesWithCustomMapping(int deptId) {
        Session session = sessionFactory.openSession();
        Query<Employee> query = session.createNamedQuery("Employee.findByDept", Employee.class);
        query.setParameter("deptId", deptId);
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);
        session.close();
    }

    // 3. Executing Database-Specific Functions
    public void countEmployees() {
        Session session = sessionFactory.openSession();
        String sql = "SELECT COUNT(*) FROM nativesql";
        Query query = session.createNativeQuery(sql);
        Number count = (Number) query.getSingleResult();

        System.out.println("Total Employees: " + count);
        session.close();
    }

    // 4. Calling Stored Procedures
    public void getEmployeesByStoredProcedure(int deptId) {
        Session session = sessionFactory.openSession();
        StoredProcedureQuery query = session.createStoredProcedureQuery("getEmployeesByDept", Employee.class);
        query.registerStoredProcedureParameter("deptId", Integer.class, jakarta.persistence.ParameterMode.IN);
        query.setParameter("deptId", deptId);
        List<Employee> employees = query.getResultList();

        employees.forEach(System.out::println);
        session.close();
    }

    // 5. Fetching Partial Columns (DTO Mapping)
    public void getEmployeeNamesByDept(int deptId) {
        Session session = sessionFactory.openSession();
        String sql = "SELECT id, name FROM nativesql WHERE department_id = :deptId";
        Query<Object[]> query = session.createNativeQuery(sql);
        query.setParameter("deptId", deptId);
        List<Object[]> results = query.getResultList();

        for (Object[] row : results) {
            System.out.println("ID: " + row[0] + ", Name: " + row[1]);
        }
        session.close();
    }
}
