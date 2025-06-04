package com.hibernate.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("HQL/HQL.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setId(1);
        student.setName("OM");
        student.setCity("Delhi");

        session.save(student);
        System.out.println("Student Saved Successfully..");

        transaction.commit();


        String query = "from Student";
        List<Student> list = session.createQuery(query, Student.class).list();
        for (Student s : list) {
            System.out.println(s.getName());
        }

        session.close();
        factory.close();
    }
}
