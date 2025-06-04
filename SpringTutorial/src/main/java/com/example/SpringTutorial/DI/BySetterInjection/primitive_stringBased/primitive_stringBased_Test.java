package com.example.SpringTutorial.DI.BySetterInjection.primitive_stringBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class primitive_stringBased_Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/BySetterInjection/primitive_stringBased/primitive_stringBased.xml");
        Employee employee = (Employee) context.getBean("emp");
        System.out.println(employee);
    }
}
