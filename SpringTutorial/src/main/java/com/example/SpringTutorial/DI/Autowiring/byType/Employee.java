package com.example.SpringTutorial.DI.Autowiring.byType;

// Employee.java
public class Employee {
    private Department department; // same type as bean

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void showEmployeeDetails() {
        department.displayDept();
    }
}

