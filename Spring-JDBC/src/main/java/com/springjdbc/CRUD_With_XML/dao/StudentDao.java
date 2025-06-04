package com.springjdbc.CRUD_With_XML.dao;

import com.springjdbc.CRUD_With_XML.entites.Student;

import java.util.List;

public interface StudentDao {

    int insert(Student student);

    int edit(Student student);

    int delete(int studentId);

    Student getStudent(int studentId);

    List<Student> getAllStudents();
}
