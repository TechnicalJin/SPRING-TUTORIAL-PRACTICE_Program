/*
package com.hibernate.CriteriaAPI;

import com.hibernate.Mapping.InheritanceMapping.JOINED.Employee;
import com.hibernate.NativeSQL.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Order;

import java.util.List;

public class CombinedCriteriaExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.gt("salary", 40000)) // Salary > 40000
                .setProjection(Projections.projectionList()
                        .add(Projections.property("name"))
                        .add(Projections.property("salary")))
                .addOrder(Order.desc(Integer.parseInt("salary"))); // Order by salary descending

        List<Object[]> results = criteria.list();
        for (Object[] row : results) {
            System.out.println("Name: " + row[0] + ", Salary: " + row[1]);
        }

        session.getTransaction().commit();
        session.close();
    }
}
*/
