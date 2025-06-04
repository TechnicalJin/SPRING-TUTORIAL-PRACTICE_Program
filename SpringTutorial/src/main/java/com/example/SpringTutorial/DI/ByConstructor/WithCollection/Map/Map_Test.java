package com.example.SpringTutorial.DI.ByConstructor.WithCollection.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Map_Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("DI/ByConstructor/WithCollection/Map/Map.xml");
        Question question = (Question) context.getBean("que");
        System.out.println(question);
    }
}
