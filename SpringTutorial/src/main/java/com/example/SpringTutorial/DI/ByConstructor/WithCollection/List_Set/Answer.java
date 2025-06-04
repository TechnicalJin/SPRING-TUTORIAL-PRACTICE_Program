package com.example.SpringTutorial.DI.ByConstructor.WithCollection.List_Set;

public class Answer {
    private int id;
    private String name;
    private String by;

    public Answer(int id, String name, String by) {
        this.id = id;
        this.name = name;
        this.by = by;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", by='" + by + '\'' +
                '}';
    }
}
