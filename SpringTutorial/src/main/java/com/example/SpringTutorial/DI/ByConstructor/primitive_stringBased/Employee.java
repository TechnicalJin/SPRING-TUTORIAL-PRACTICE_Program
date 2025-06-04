package com.example.SpringTutorial.DI.ByConstructor.primitive_stringBased;

public class Employee {

    private int id;
    private String name;

    public Employee(){
        System.out.printf("def cons");
    }

    public Employee(int id){
        this.id = id;
    }

    public Employee(String name){
        this.name = name;
    }

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
