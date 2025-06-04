package com.hibernate.Mapping.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyToManyDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("Mapping/Mapping.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Emp e1 = new Emp();
        e1.setEid(1);
        e1.setName("Ram");
        Project p1 = new Project();
        p1.setPid(1);
        p1.setProjectName("Library Management System");


        Emp e2 = new Emp();
        e2.setEid(2);
        e2.setName("Shyam");
        Project p2 = new Project();
        p2.setPid(2);
        p2.setProjectName("Chatbot");


        List<Emp> list1 = new ArrayList<>();
        List<Project> list2 = new ArrayList<>();

        list1.add(e1);
        list1.add(e2);


        list2.add(p1);
        list2.add(p2);


        //
        e1.setProjects(list2);
        p1.setEmps(list1);


        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();


        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);

        tx.commit();
        s.close();
        factory.close();
    }
}
