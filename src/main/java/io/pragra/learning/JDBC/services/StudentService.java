package io.pragra.learning.JDBC.services;

import io.pragra.learning.JDBC.entities.Student;
import io.pragra.learning.JDBC.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public Student updateStudent(Integer id, Student updatedStudent) {
        // Optional: Check if student exists
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        // Update fields
        existingStudent.setEmail(updatedStudent.getEmail());


        // Save updated entity
        return studentRepo.save(existingStudent);
    }

}
