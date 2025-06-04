package com.hibernate.Mapping.oneToMany;

import jakarta.persistence.*;

@Entity
public class AnswerOneToMany {

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionOneToMany oneQue;

    public AnswerOneToMany() {
        super();
    }

    public AnswerOneToMany(int answerId, String answer, QuestionOneToMany oneQue) {
        this.answerId = answerId;
        this.answer = answer;
        this.oneQue = oneQue;
    }



    @Override
    public String toString() {
        return "AnswerOneToMany{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", oneQue=" + oneQue +
                '}';
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionOneToMany getOneQue() {
        return oneQue;
    }

    public void setOneQue(QuestionOneToMany oneQue) {
        this.oneQue = oneQue;
    }
}
