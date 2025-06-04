package com.hibernate.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class QueryExample {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("HQL/Query.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Product p1 = new Product("Laptop", "Gaming Laptop", 1500.0, "Electronics");
        Product p2 = new Product("Phone", "Android Phone", 800.0, "Electronics");
        Product p3 = new Product("Tablet", "iPad", 1200.0, "Electronics");
        Product p4 = new Product("Chair", "Office Chair", 200.0, "Furniture");
        Product p5 = new Product("Desk", "Wooden Desk", 500.0, "Furniture");

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);

        transaction.commit();


        // Retrieve all products
        Query<Product> query1 = session.createQuery("FROM Product", Product.class);
        List<Product> products = query1.list();
        System.out.println("\nAll Products:");
        products.forEach(System.out::println);

        // Retrieve product by ID
        Query<Product> query2 = session.createQuery("FROM Product WHERE id = :productId", Product.class);
        query2.setParameter("productId", 1L);
        Product productById = query2.uniqueResult();
        System.out.println("\nProduct with ID 1: " + productById);

        // Retrieve product by name
        Query<Product> query3 = session.createQuery("FROM Product WHERE name = :productName", Product.class);
        query3.setParameter("productName", "Laptop");
        Product productByName = query3.uniqueResult();
        System.out.println("\nProduct with name 'Laptop': " + productByName);

        // Retrieve products with price greater than a value
        Query<Product> query4 = session.createQuery("FROM Product WHERE price > :minPrice", Product.class);
        query4.setParameter("minPrice", 1000.0);
        List<Product> expensiveProducts = query4.list();
        System.out.println("\nProducts with price greater than $1000:");
        expensiveProducts.forEach(System.out::println);

        // Retrieve products containing a specific string (LIKE)
        Query<Product> query5 = session.createQuery("FROM Product WHERE name LIKE :searchString", Product.class);
        query5.setParameter("searchString", "%Phone%");
        List<Product> matchedProducts = query5.list();
        System.out.println("\nProducts with 'Phone' in the name:");
        matchedProducts.forEach(System.out::println);

        // Retrieve products by category
        Query<Product> query6 = session.createQuery("FROM Product WHERE category = :categoryName", Product.class);
        query6.setParameter("categoryName", "Electronics");
        List<Product> electronics = query6.list();
        System.out.println("\nProducts in 'Electronics' category:");
        electronics.forEach(System.out::println);

        // Retrieve products sorted by price (ascending)
        Query<Product> query7 = session.createQuery("FROM Product ORDER BY price ASC", Product.class);
        List<Product> sortedProductsAsc = query7.list();
        System.out.println("\nProducts sorted by price (Ascending):");
        sortedProductsAsc.forEach(System.out::println);

        // Retrieve products sorted by price (descending)
        Query<Product> query8 = session.createQuery("FROM Product ORDER BY price DESC", Product.class);
        List<Product> sortedProductsDesc = query8.list();
        System.out.println("\nProducts sorted by price (Descending):");
        sortedProductsDesc.forEach(System.out::println);

        // Retrieve limited number of products (pagination)
        Query<Product> query9 = session.createQuery("FROM Product", Product.class);
        query9.setFirstResult(0); // Start index
        query9.setMaxResults(3); // Max results
        List<Product> paginatedProducts = query9.list();
        System.out.println("\nFirst 3 Products:");
        paginatedProducts.forEach(System.out::println);

        // Retrieve average price of all products
        Query<Double> query10 = session.createQuery("SELECT AVG(price) FROM Product", Double.class);
        Double avgPrice = query10.uniqueResult();
        System.out.println("\nAverage Price of Products: " + avgPrice);

        // Retrieve count of products in a category
        Query<Long> query11 = session.createQuery("SELECT COUNT(*) FROM Product WHERE category = :categoryName", Long.class);
        query11.setParameter("categoryName", "Furniture");
        Long count = query11.uniqueResult();
        System.out.println("\nCount of Furniture products: " + count);

        // Retrieve products with a name in a list
        Query<Product> query12 = session.createQuery("FROM Product WHERE name IN (:nameList)", Product.class);
        query12.setParameter("nameList", List.of("Laptop", "Desk"));
        List<Product> filteredProducts = query12.list();
        System.out.println("\nProducts with name 'Laptop' or 'Desk':");
        filteredProducts.forEach(System.out::println);


        session.close();
        factory.close();
    }
}
