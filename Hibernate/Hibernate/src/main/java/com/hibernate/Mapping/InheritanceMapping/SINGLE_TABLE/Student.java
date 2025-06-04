package com.hibernate.Mapping.InheritanceMapping.SINGLE_TABLE;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    private String course;

    @Override
    public String toString() {
        return "Student{" +
                "course='" + course + '\'' +
                '}';
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(long id, String name, String course) {
        super(id, name);
        this.course = course;
    }

    public Student(String course) {
        this.course = course;
    }

    public Student() {
    }
}
