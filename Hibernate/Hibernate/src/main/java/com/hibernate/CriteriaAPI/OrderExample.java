/*
package com.hibernate.CriteriaAPI;

import org.hibernate.criterion.Order;

public class OrderExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.addOrder(Order.desc("salary")); // Sort by salary in descending order

        List<Employee> employees = criteria.list();
        for (Employee emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getSalary());
        }

        session.getTransaction().commit();
        session.close();
    }
}
*/
