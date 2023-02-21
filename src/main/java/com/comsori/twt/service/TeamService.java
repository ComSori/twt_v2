package com.comsori.twt.service;

import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.entity.Team;

public interface TeamService {
    TeamResponseDto saveTeam(TeamDto teamDto);

    TeamResponseDto getTeam(TeamDto teamDto);

    TeamResponseDto updateTeam(TeamDto teamDto);

    void deleteTeam(String teamId);

}
