package com.example.SpringTutorial.DI.Autowiring.constructor;

// Employee.java
public class Employee {
    private Department department;

    public Employee(Department department) {
        this.department = department;
    }

    public void showEmployeeDetails() {
        department.displayDept();
    }
}

