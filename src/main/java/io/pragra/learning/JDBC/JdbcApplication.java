package io.pragra.learning.JDBC;

import io.pragra.learning.JDBC.services.StudentService;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
		StudentService studentService = context.getBean(StudentService.class);
		System.out.println(studentService.getStudents());

	}


}
