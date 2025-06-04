/*
package com.hibernate.CriteriaAPI;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import java.util.List;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Creating Criteria for Employee
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.gt("salary", 50000)); // Salary > 50000

        List<Employee> employees = criteria.list();
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getSalary());
        }

        session.getTransaction().commit();
        session.close();
    }
}
*/
