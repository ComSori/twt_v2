package com.comsori.twt.service;

import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.dto.TeamUpdateDto;
import com.comsori.twt.data.entity.Team;

public interface TeamService {
    void buildTeam(TeamDto teamDto);

    void joinTeam(TeamMemberDto teamMemberDto);

    TeamResponseDto getTeam(TeamDto teamDto);

    TeamResponseDto updateTeam(TeamUpdateDto teamUpdateDto);

    TeamResponseDto memberInvite(TeamMemberDto teamMemberDto);

    void deleteTeam(String teamId);

}
