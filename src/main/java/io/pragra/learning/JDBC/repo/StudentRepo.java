package io.pragra.learning.JDBC.repo;

import io.pragra.learning.JDBC.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstName(String name);

    @Query(nativeQuery = true, value = "select s.last_name from student s where s.NAME = ?")
    List<String> findAllLastNamesByFirstName(String name);
}
