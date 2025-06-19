package io.pragra.learning.JDBC.feignclients;

import io.pragra.learning.JDBC.entities.GithubUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "studentClient", url = "https://api.github.com/users")
public interface StudentClient {
    @GetMapping("/{login}")
    ResponseEntity<GithubUser> getGitUser(@PathVariable String login);
}
