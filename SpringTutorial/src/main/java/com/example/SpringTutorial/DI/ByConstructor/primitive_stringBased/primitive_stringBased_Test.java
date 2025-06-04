package com.example.SpringTutorial.DI.ByConstructor.primitive_stringBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class primitive_stringBased_Test {

    public static void main(String[] args) {

        ApplicationContext context =new ClassPathXmlApplicationContext("DI/ByConstructor/primitive_stringBased/primitive_stringBased.xml");
        Employee employee =(Employee) context.getBean("emp");
        Employee employee1 =(Employee) context.getBean("emp1");
        Employee employee2 =(Employee) context.getBean("emp2");

        System.out.println(employee);
        System.out.println();
        System.out.println(employee1);
        System.out.println();
        System.out.println(employee2);
        System.out.println();
    }
}
