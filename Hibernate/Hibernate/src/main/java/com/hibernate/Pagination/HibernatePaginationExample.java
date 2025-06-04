package com.hibernate.Pagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernatePaginationExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("Pagination/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        int pageSize = 5;

        for (int pageNumber = 0; pageNumber < 4; pageNumber++) {
            System.out.println("\n--- Page " + (pageNumber + 1) + " ---");

            Query<Product> query = session.createQuery("FROM Product", Product.class);
            query.setFirstResult(pageNumber * pageSize);
            query.setMaxResults(pageSize);

            List<Product> products = query.list();
            products.forEach(System.out::println);
        }

        session.close();
        factory.close();
    }
}
