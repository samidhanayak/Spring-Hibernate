package io.pragra.learning.JDBC.services;

import io.pragra.learning.JDBC.entities.GithubUser;
import io.pragra.learning.JDBC.feignclients.GitUserRepo;
import io.pragra.learning.JDBC.feignclients.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class GithubUserService {
    @Autowired
    private GitUserRepo repo;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;
    @Autowired
    StudentClient studentClient;
    public GithubUser fetchAndPersist(String login){
        // Rest template
        //ResponseEntity<GithubUser> githubUserResponseEntity = consumeWithWebClient(login);
        ResponseEntity<GithubUser> githubUserResponseEntity = studentClient.getGitUser(login);
        if(Objects.nonNull(githubUserResponseEntity.getBody())
                && Objects.nonNull(githubUserResponseEntity.getBody().getId())){
            repo.save(githubUserResponseEntity.getBody());
            return githubUserResponseEntity.getBody();
        }
        return new GithubUser();
    }

    private ResponseEntity<GithubUser> consumeWithWebClient(String login) {
        Mono<ResponseEntity<GithubUser>> githubUserMonoResponseEntityMono = webClient
                .get()
                .uri("https://api.github.com/users/" + login)
                .header("authId", "HeadervalueAuthID")
                .header("authPass","HeadervalueAuthPass")
                .retrieve()
                .toEntity(GithubUser.class);
        ResponseEntity<GithubUser> githubUserResponseEntity = githubUserMonoResponseEntityMono.block();
        return githubUserResponseEntity;
    }

    private ResponseEntity<GithubUser> consumeWithRestTemplate(String login){
        ResponseEntity<GithubUser> githubUserResponseEntity = restTemplate
                .exchange("https://api.github.com/users/" + login, HttpMethod.GET, null , GithubUser.class);
        return githubUserResponseEntity;
    }
}
