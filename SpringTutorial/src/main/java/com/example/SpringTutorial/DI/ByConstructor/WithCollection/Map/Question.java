package com.example.SpringTutorial.DI.ByConstructor.WithCollection.Map;

import java.util.Map;

public class Question {

    private int id;
    private String name;
    private Map<Answer, User> answerUserMap;

    public Question() {
    }

    public Question(int id, String name, Map<Answer, User> answerUserMap) {
        this.id = id;
        this.name = name;
        this.answerUserMap = answerUserMap;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answerUserMap=" + answerUserMap +
                '}';
    }
}
