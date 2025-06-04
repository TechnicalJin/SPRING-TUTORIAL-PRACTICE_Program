package com.hibernate.Mapping.InheritanceMapping.SINGLE_TABLE;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person{

    public double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(long id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
}
