package com.hibernate.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NativeSQLQuery {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // SQL Query
        String q = "select * from product";
        NativeQuery nativeQuery = session.createNativeQuery(q);

        List<Object[]> list = nativeQuery.list();
        for (Object[] obj : list){
            System.out.println(obj[3] + " : " + obj[4]);
        }

        session.close();
        factory.close();
    }
}
