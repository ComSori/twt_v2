package com.comsori.twt.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    private String team_id;

    @Column(nullable = false)
    private String team_name;

    @Column(nullable = false)
    private String team_password;

    @Column
    private String team_leader;

    @Column
    private String team_cloud;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Post> posts;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<User> user;
}
