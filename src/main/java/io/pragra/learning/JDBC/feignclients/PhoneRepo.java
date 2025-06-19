package io.pragra.learning.JDBC.feignclients;

import io.pragra.learning.JDBC.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Integer> {
}
