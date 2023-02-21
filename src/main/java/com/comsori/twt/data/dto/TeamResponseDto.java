package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.BelongedTeam;
import com.comsori.twt.data.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDto {
    private String teamId;
    private String teamName;
    //private String teamPassword;
    private String teamLeader;
    //private String teamCloud;
    private List<Post> posts;
    private List<BelongedTeam> belongedTeams;
}
