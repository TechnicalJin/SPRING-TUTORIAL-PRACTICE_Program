package com.example.SpringTutorial.DI.ByConstructor.WithCollection.List_Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class List_Set_Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("DI/ByConstructor/WithCollection/List_Set/List_Set.xml");

        Question question = (Question) context.getBean("question");

        System.out.println();
        System.out.println(question);
        System.out.println();
    }
}
