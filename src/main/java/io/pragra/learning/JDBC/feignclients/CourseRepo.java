package io.pragra.learning.JDBC.feignclients;

import io.pragra.learning.JDBC.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
