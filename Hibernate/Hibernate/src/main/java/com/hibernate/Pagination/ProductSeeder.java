package com.hibernate.Pagination;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductSeeder {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("Pagination/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        for (int i = 1; i <= 20; i++) {
            Product product = new Product("Product " + i, "Description " + i, 100.0 + i, "Category " + (i % 3));
            session.save(product);
        }

        transaction.commit();
        session.close();
        factory.close();

        System.out.println("Products Inserted Successfully..");
    }
}
