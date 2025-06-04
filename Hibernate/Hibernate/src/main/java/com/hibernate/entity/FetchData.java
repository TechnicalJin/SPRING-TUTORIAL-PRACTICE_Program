package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("Hibernate/Hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.openSession();

        // Get Student Using Id
        Student student = (Student) session.load(Student.class, 1);
//        System.out.println();
//        System.out.println(student);
        System.out.println();

        // Getting Address
        Address address = (Address) session.get(Address.class, 1);
        System.out.println(address.getStreet() + " : " + address.getCity());

        Address address1 = (Address) session.get(Address.class, 1);
        System.out.println(address1.getStreet() + " : " + address1.getCity());

        session.close();
        factory.close();
    }
}
