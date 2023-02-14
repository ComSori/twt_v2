package com.comsori.twt.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "post_id")
    private int postId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Lob
    private String postContent;

    @Column
    private int postPositionX;

    @Column
    private int postPositionY;
}
