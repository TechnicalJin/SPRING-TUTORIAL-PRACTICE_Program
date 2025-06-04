package com.springjdbc.CRUD_Without_XML;

import com.springjdbc.CRUD_With_XML.dao.StudentDao;
import com.springjdbc.CRUD_With_XML.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.CRUD_With_XML.dao"})
public class JdbcConfig {

    @Bean("ds")
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/jdbcpractice1");
        ds.setUsername("root");
        ds.setPassword("Varun@2005");

        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());

        return jdbcTemplate;
    }


    // Configured With @Autowired
//    @Bean(name = {"studentDao"})
//    public StudentDao  getStudentDao(){
//
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.setJdbcTemplate(getTemplate());
//
//        return studentDao;
//    }
}
