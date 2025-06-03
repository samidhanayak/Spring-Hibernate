package io.pragra.learning.JDBC.services;

import io.pragra.learning.JDBC.entities.Student;
import io.pragra.learning.JDBC.repo.StudentRepo;
import io.pragra.learning.JDBC.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentUtils studentUtils;

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

    public Optional<Student> getStudentById(Integer id){
        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent;
    }

    public Student createStudent(Student student){
        Student studentEntity = studentRepo.save(student);
        return studentEntity;
    }

    public Student updateStudent(Student student){
        Optional<Student> optionalStudent = studentRepo.findById(student.getId());
        if (optionalStudent.isPresent()){
            return studentRepo.save(student);
        }
        return student;
    }

    public Student patchUpdate(Student dto){
        Optional<Student> optionalStudent = studentRepo.findById(dto.getId());
        Student entity = null;
        if (!optionalStudent.isPresent()) {
            return null;
        }
        entity = optionalStudent.get();
        studentUtils.convertPatchDto(dto,entity);

        return studentRepo.save(entity);
    }

    public List<Student> getAllByFirstName(String firstName){
        List<Student> allByFirstName = studentRepo.findAllByFirstName(firstName);
        return allByFirstName;
    }

}
