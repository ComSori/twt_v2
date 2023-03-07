package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberDto {
    private String teamId;
    private String userId;
    private String teamPassword;
}
