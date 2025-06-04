package com.hibernate.Mapping.oneToMany;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class QuestionOneToMany {

    @Id
    @Column(name = "question_id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "oneQue", fetch = FetchType.EAGER)
    private List<AnswerOneToMany> answerList;


    public QuestionOneToMany() {
        super();
    }

    public List<AnswerOneToMany> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerOneToMany> answerList) {
        this.answerList = answerList;
    }

    public QuestionOneToMany(int questionId, String question, List<AnswerOneToMany> answerList) {
        this.questionId = questionId;
        this.question = question;
        this.answerList = answerList;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



    @Override
    public String toString() {
        return "QuestionOneToMany{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                '}';
    }
}
