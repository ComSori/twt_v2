package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.BelongedTeam;
import com.comsori.twt.data.entity.Post;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TeamDto {
    private String teamId;
    private String teamName;
    private String teamPassword;
    private String teamLeader;
    //private String teamCloud add later
    private List<Post> post;
    private List<BelongedTeam> belongedTeam;
}
