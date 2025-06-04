package com.example.SpringTutorial.DI.Autowiring.constructor;

// Department.java
public class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDept() {
        System.out.println("Department Name: " + deptName);
    }
}
