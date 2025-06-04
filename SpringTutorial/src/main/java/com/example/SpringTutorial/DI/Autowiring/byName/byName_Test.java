package com.example.SpringTutorial.DI.Autowiring.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class byName_Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/Autowiring/byName/byName.xml");
        Employee employee = (Employee) context.getBean("emp", Employee.class);
        System.out.println(employee);
    }
}
