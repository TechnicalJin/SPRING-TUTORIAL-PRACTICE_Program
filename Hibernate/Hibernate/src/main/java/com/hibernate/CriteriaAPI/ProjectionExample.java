/*
package com.hibernate.CriteriaAPI;

import com.hibernate.Mapping.InheritanceMapping.JOINED.Employee;
import com.hibernate.NativeSQL.HibernateUtil;
import org.hibernate.Session;

public class ProjectionExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Employee.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("name"))
                .add(Projections.property("salary")));

        List<Object[]> results = criteria.list();
        for (Object[] row : results) {
            System.out.println("Name: " + row[0] + ", Salary: " + row[1]);
        }

        session.getTransaction().commit();
        session.close();
    }
}
*/
