package com.example.SpringTutorial.DI.ByConstructor.DependentObject;

public class Employee {

    private int id;
    private String name;
    private Address address;

    public Employee() {
        System.out.println("Without Fields");
    }

    public Employee(int id, String name, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
