package com.hibernate.Mapping.InheritanceMapping.SINGLE_TABLE;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SINGLE_TABLE_Demo {

    public static void main(String[] args) {

        // Step 1: Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("InheritanceMapping/InheritanceMapping.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Step 2: Open Session
        Session session = factory.openSession();

        // Step 3: Begin Transaction
        Transaction tx = session.beginTransaction();

        // Creating Employee Object
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(75000.0);

        // Creating Student Object
        Student stud = new Student();
        stud.setName("Alice Smith");
        stud.setCourse("Computer Science");

        // Saving Data into Database
        session.save(emp);
        session.save(stud);

        // Step 4: Commit Transaction
        tx.commit();

        // Step 5: Close Session and Factory
        session.close();
        factory.close();

        System.out.println("Data saved successfully!");
    }
}
