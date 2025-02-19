package com.springjdbc.SpringJDBC.Repository;

import com.springjdbc.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save student to the database
    public void save(Student student) {
        String sql = "INSERT INTO student (srollno, sname, smarks) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getSrollno(), student.getSname(), student.getSmarks());
        System.out.println("Student added successfully.");
    }

    // Fetch all students from the database
    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    // RowMapper to map database rows to Student object
    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setSrollno(rs.getInt("srollno"));
            student.setSname(rs.getString("sname"));
            student.setSmarks(rs.getInt("smarks"));
            return student;
        }
    }
}
