package com.example.SpringTutorial.DI.Autowiring.byName;

public class Employee {

    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                '}';
    }
}
