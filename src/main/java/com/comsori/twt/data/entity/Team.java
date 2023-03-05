package com.comsori.twt.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @Column
    private String teamId;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String teamPassword;

    @Column
    private String teamLeader;

    @Column
    private String teamCloud;

    @OneToMany(mappedBy = "team")
    private List<Post> post;

    @OneToMany(mappedBy = "team")
    private List<BelongedTeam> belongedTeam;
}
