package com.springjdbc.CRUD_With_XML.dao;

import com.springjdbc.CRUD_With_XML.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Insert Query
    public int insert(Student student) {
        String query = " insert into student(id, name, city) values(?, ?, ?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }


    // Update Query
    @Override
    public int edit(Student student) {
        String query = " update student set name=?, city=? where id=?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return result;
    }


    // Delete Query
    @Override
    public int delete(int studentId) {
        String query = " delete from student where id =?";
        int result = this.jdbcTemplate.update(query, studentId);
        return result;
    }


    // Selecting Single Row
    @Override
    public Student getStudent(int studentId) {

        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();

        return this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
    }


    // Selecting Multiple Row
    @Override
    public List<Student> getAllStudents() {

        String query = "select * from student";

        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
        return students;
    }
}
