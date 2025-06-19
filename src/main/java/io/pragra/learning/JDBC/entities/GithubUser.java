package io.pragra.learning.JDBC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubUser {
    @Id
    private Integer id;
    private String login;
    private String name;
    private String company;
    private String node_id;
    private String avatar_url;
    private String url;
    private String html_url;
    private String followers_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String repos_url;

}
