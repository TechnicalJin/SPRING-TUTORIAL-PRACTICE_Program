package com.example.SpringTutorial.DI.ByConstructor.WithCollection.List_Set;

import java.util.List;

public class Question {
    private int id;
    private String name;
    private List<String> answers;
    private List<Answer> answerList;

    public Question(int id, String name, List<String> answers, List<Answer> answerList) {
        this.id = id;
        this.name = name;
        this.answers = answers;
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answers=" + answers +
                ", answerList=" + answerList +
                '}';
    }
}
