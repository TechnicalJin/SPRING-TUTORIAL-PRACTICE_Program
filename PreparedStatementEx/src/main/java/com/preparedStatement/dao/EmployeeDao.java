package com.preparedStatement.dao;

import com.preparedStatement.entity.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean saveEmployeeByPreparedStatement(final Employee employee){
        String query = "INSERT INTO employee VALUES(?, ?, ?)";

        return Boolean.TRUE.equals(jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setInt(1, employee.getId());
                ps.setString(2, employee.getName());
                ps.setFloat(3, employee.getSalary());

                return ps.execute();
            }
        }));
    }

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("SELECT * FROM employee", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

                List<Employee> list = new ArrayList<>();

                while (rs.next()){
                    Employee employee = new Employee();

                    employee.setId(rs.getInt(1));
                    employee.setName(rs.getString(2));
                    employee.setSalary(rs.getFloat(3));
                }

                return list;
            }
        });
    }
}
