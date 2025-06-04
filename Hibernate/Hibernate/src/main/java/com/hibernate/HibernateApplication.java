package com.hibernate;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("Project Started..");

		Configuration cfg = new Configuration();
		cfg.configure("Hibernate/Hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println();
		/*System.out.println(factory);*/

		/*System.out.println(factory.isClosed());*/

		// Creating Student
		Student student = new Student();
		student.setId(1);
		student.setName("OM");
		student.setCity("Surat");

		System.out.println(student);
		System.out.println();


		// Creating Object Of Address
		Address address = new Address();
		address.setStreet("street1");
		address.setCity("Delhi");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(123.123);

		// Reading Image
		FileInputStream fileInputStream = new FileInputStream("C:\\JAVA\\SPRING TUTORIAL\\Hibernate\\Hibernate\\src\\main\\resources\\Hibernate\\image.png");
		byte[] data = new byte[fileInputStream.available()];
		fileInputStream.read(data);
		address.setImage(data);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(student);
		session.save(address);
		transaction.commit();
		session.close();
		System.out.println("Session Is Closed..");
	}
}