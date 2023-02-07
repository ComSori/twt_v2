package com.comsori.twt.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_id;

    @Column
    private String board_title;

    @Lob
    private String board_content;

    @Column
    private Boolean board_notice;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    })
    private BelongedTeam belongedTeam;

    @CreatedDate
    private LocalDateTime board_createDate;

    @LastModifiedDate
    private LocalDateTime board_modifiedDate;
}
