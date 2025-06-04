package com.hibernate.Mapping.InheritanceMapping.JOINED;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {

    private String course;
}
