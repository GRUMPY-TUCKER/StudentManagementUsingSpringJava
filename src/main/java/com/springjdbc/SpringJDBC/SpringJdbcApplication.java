package com.springjdbc.SpringJDBC;

import com.springjdbc.SpringJDBC.Service.StudentService;
import com.springjdbc.SpringJDBC.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		// Get the StudentService bean
		StudentService studentService = context.getBean(StudentService.class);

		// Fetch and print student records from PostgreSQL
		List<Student> students = studentService.getStudents();
		students.forEach(s -> System.out.println(
				"Roll No: " + s.getSrollno() + ", Name: " + s.getSname() + ", Marks: " + s.getSmarks()));
	}
}
