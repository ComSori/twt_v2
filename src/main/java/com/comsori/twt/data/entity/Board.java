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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardId;

    @Column
    private String boardTitle;

    @Lob
    private String boardContent;

    @Column
    private Boolean boardNotice;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    })
    private BelongedTeam belongedTeam;

    @CreatedDate
    private LocalDateTime boardCreateDate;

    @LastModifiedDate
    private LocalDateTime boardModifiedDate;
}
