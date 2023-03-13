package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.BelongedTeam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private String teamId;
    private String teamName;
    private String teamPassword;
    private String teamLeader;
    private List<BelongedTeam> belongedTeams;
}
