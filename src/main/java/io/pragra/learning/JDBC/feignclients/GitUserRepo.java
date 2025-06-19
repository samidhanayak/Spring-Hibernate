package io.pragra.learning.JDBC.feignclients;
import io.pragra.learning.JDBC.entities.GithubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitUserRepo extends JpaRepository<GithubUser, Integer> {
}
