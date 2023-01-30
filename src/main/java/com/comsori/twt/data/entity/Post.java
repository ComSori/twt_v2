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
    private int post_id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Team team;

    @Lob
    private String post_content;

    @Column
    private int post_positionX;

    @Column
    private int post_positionY;
}
