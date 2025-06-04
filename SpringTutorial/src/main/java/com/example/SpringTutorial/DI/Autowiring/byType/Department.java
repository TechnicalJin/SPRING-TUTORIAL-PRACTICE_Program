package com.example.SpringTutorial.DI.Autowiring.byType;

// Department.java
public class Department {
    private String deptName;

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void displayDept() {
        System.out.println("Department Name: " + deptName);
    }
}

