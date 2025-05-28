package io.pragra.learning.JDBC.runner;

import io.pragra.learning.JDBC.entities.Student;
import io.pragra.learning.JDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataLoader implements CommandLineRunner {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student();
        student.setId(6);
        student.setFirstName("Tom");
        student.setLastName("H");
        student.setEmail("Tom@gmail.com");
        student.setPhoneNumber("12334355");

        studentRepo.save(student);
    }
}
