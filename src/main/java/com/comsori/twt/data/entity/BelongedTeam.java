package com.comsori.twt.data.entity;

import com.comsori.twt.data.embeddedid.BelongedTeamId;
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
@IdClass(BelongedTeamId.class)
public class BelongedTeam {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
