package com.comsori.twt.service;

import com.comsori.twt.data.dto.TeamBuildDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.dto.TeamDto;

public interface TeamService {
    void buildTeam(TeamBuildDto teamBuildDto);

    void joinTeam(TeamMemberDto teamMemberDto);

    TeamResponseDto getTeam(TeamBuildDto teamBuildDto);

    TeamResponseDto updateTeam(TeamDto teamDto);

    TeamResponseDto memberInvite(TeamMemberDto teamMemberDto);

    void deleteTeam(TeamMemberDto teamMemberDto);

}
