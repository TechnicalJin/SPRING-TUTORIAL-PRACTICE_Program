package com.hibernate.Mapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("Mapping/Mapping.cfg.xml");
        SessionFactory factory = configuration.buildSessionFactory();


        // Student 1
        Question question = new Question();
        question.setQuestionId(1);;
        question.setQuestion("What is java");


        Answer answer = new Answer();
        answer.setAnswerId(1);
        answer.setAnswer("Java Is Programing Language");
        answer.setQuestion(question);

        question.setAnswer(answer);




        Question question2 = new Question();
        question2.setQuestionId(2);
        question2.setQuestion("What is Hibernate");

        Answer answer2 = new Answer();
        answer2.setAnswerId(2);
        answer2.setAnswer("Hibernate Is Spring Framework");
        answer2.setQuestion(question2);

        question2.setAnswer(answer2);


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(question);
        session.save(question2);
        session.save(answer);
        session.save(answer2);



        // Fetch data
        Question question1 = (Question) session.get(Question.class, 1);
        System.out.println();
        System.out.println("Question : " + question1.getQuestion());


        transaction.commit();
        session.close();

        factory.close();
    }
}
