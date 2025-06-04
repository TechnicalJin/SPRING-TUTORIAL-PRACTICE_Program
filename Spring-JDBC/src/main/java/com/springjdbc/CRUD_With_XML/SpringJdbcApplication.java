package com.springjdbc.CRUD_With_XML;

import com.springjdbc.CRUD_With_XML.dao.StudentDao;
import com.springjdbc.CRUD_With_XML.entites.Student;
import com.springjdbc.CRUD_Without_XML.JdbcConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        System.out.println("Program Started..");

        // With Use Of XML File
//		ApplicationContext context = new ClassPathXmlApplicationContext("CRUD_With_XML/config.xml");

        // Without Use Of Xml File
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // Insert
//		Student student = new Student();
//		student.setId(123);
//		student.setName("John");
//		student.setCity("Ahmedabad");
//
//		int result = studentDao.insert(student);
//		System.out.println("Student Added.. " + result);


        // Update
//		Student student = new Student();
//		student.setId(123);
//		student.setName("Raj Kumar");
//		student.setCity("Delhi");
//
//		int result = studentDao.edit(student);
//		System.out.println("Student Updated.. "+ result);


        // Delete
//		int result = studentDao.delete(123);
//		System.out.println("Student Deleted Successfully.. "+ result);


        // Selecting Single Row
//		Student student = studentDao.getStudent(12);
//		System.out.println(student);


        // Selecting Multiple Row
        List<Student> studentList = studentDao.getAllStudents();
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}