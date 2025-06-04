package com.hibernate.Mapping.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import jakarta.persistence.criteria.JoinType;

public class OneToMany {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oneToMany/oneToMany.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Save data
        saveData(factory);
        
        // Demonstrate different fetch techniques
        demonstrateFetchTechniques(factory);

        factory.close();
    }

    private static void saveData(SessionFactory factory) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        QuestionOneToMany question = new QuestionOneToMany();
        question.setQuestionId(1);
        question.setQuestion("What is Hibernate?");

        AnswerOneToMany ans1 = new AnswerOneToMany(101, "Hibernate is an ORM tool", question);
        AnswerOneToMany ans2 = new AnswerOneToMany(102, "It simplifies database interactions", question);
        AnswerOneToMany ans3 = new AnswerOneToMany(103, "It supports various databases", question);

        question.setAnswerList(Arrays.asList(ans1, ans2, ans3));

        session.persist(question);
        session.persist(ans1);
        session.persist(ans2);
        session.persist(ans3);

        tx.commit();
        session.close();
    }

    private static void demonstrateFetchTechniques(SessionFactory factory) {
        Session session = factory.openSession();
        try {
            // 1. Eager Loading (default fetch type in QuestionOneToMany)
            System.out.println("\n=== Eager Loading ===");
            QuestionOneToMany question = session.get(QuestionOneToMany.class, 1);
            System.out.println("Question: " + question.getQuestion());
            // Answers are already loaded due to EAGER loading
            System.out.println("Answers: " + question.getAnswerList().size());

            // 2. Lazy Loading (from AnswerOneToMany side)
            System.out.println("\n=== Lazy Loading ===");
            AnswerOneToMany answer = session.get(AnswerOneToMany.class, 101);
            System.out.println("Answer: " + answer.getAnswer());
            // This will trigger lazy loading of the question
            System.out.println("Related Question: " + answer.getOneQue().getQuestion());

            // 3. Criteria Query with Join Fetch
            System.out.println("\n=== Criteria Query with Join Fetch ===");
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<QuestionOneToMany> criteriaQuery = builder.createQuery(QuestionOneToMany.class);
            Root<QuestionOneToMany> root = criteriaQuery.from(QuestionOneToMany.class);
            root.fetch("answerList", JoinType.LEFT);
            criteriaQuery.select(root);
            @SuppressWarnings("unused")
            List<QuestionOneToMany> questions = session.createQuery(criteriaQuery).getResultList();
            
            // 4. HQL Query with Join Fetch
            System.out.println("\n=== HQL Query with Join Fetch ===");
            @SuppressWarnings("unused")
            List<QuestionOneToMany> hqlQuestions = session.createQuery(
                "from QuestionOneToMany q left join fetch q.answerList", 
                QuestionOneToMany.class
            ).getResultList();

        } finally {
            session.close();
        }
    }
}