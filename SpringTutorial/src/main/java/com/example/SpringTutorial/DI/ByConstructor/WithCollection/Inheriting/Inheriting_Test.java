package com.example.SpringTutorial.DI.ByConstructor.WithCollection.Inheriting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inheriting_Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/ByConstructor/WithCollection/Inheriting/Inheriting.xml");
        Employee employee = (Employee) context.getBean("emp2");
        System.out.println(employee);
        System.out.println();
    }
}
