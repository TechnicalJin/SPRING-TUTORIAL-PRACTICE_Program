package com.hibernate.Mapping.InheritanceMapping.JOINED;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {

    private double salary;
}
