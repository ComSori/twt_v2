package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.BelongedTeam;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeamBuildDto {
    private String teamId;
    private String teamName;
    private String teamPassword;
    private String teamLeader;//uid
}
