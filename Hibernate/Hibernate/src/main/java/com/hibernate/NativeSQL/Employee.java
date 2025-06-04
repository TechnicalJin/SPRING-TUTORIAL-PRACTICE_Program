package com.hibernate.NativeSQL;

import jakarta.persistence.*;

@Entity
@Table(name = "nativesql")
@NamedNativeQuery(
        name = "Employee.findByDepartment",
        query = "SELECT * FROM nativesql WHERE department_id = :deptId",
        resultClass = Employee.class
)
@SqlResultSetMapping(
        name = "EmployeeMapping",
        entities = @EntityResult(entityClass = Employee.class)
)
@NamedNativeQuery(
        name = "Employee.findByDept",
        query = "SELECT id, name, department_id FROM nativesql WHERE department_id = :deptId",
        resultSetMapping = "EmployeeMapping"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "department_id")
    private int departmentId;

    public Employee() {}

    public Employee(String name, int departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
