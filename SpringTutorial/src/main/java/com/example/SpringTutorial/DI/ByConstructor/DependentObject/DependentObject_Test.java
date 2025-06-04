package com.example.SpringTutorial.DI.ByConstructor.DependentObject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependentObject_Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/ByConstructor/DependentObject/DependentObject.xml");
        Employee employee = (Employee) context.getBean("emp");

        System.out.println(employee);
    }
}
