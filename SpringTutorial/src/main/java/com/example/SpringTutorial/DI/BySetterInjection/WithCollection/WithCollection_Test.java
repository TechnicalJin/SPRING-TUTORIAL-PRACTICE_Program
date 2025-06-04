package com.example.SpringTutorial.DI.BySetterInjection.WithCollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithCollection_Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/BySetterInjection/WithCollection/WithCollection.xml");
        Question question = (Question) context.getBean("que");
        System.out.println(question);
    }
}
