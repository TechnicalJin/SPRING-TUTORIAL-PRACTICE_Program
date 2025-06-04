package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("Hibernate/Hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();

        // Student 1
        Student student = new Student();
        student.setId(2);
        student.setName("John");
        student.setCity("Ahmedabad");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("2 Month");

        student.setCertificate(certificate);


        // Student 2
        Student student2 = new Student();
        student2.setId(3);
        student2.setName("Lit");
        student2.setCity("Delhi");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("DSA");
        certificate2.setDuration("4 Month");

        student2.setCertificate(certificate2);



        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        // Object save
        System.out.println();
        session.save(student);
        System.out.println("Student student saved..");
        System.out.println();

        session.save(student2);
        System.out.println("Student student2 saved..");
        System.out.println();

        transaction.commit();
        session.close();
        factory.close();
    }
}
