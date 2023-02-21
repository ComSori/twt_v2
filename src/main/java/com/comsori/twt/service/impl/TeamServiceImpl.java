package com.comsori.twt.service.impl;

import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.entity.Team;
import com.comsori.twt.repository.TeamRepository;
import com.comsori.twt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }

    @Override
    public TeamResponseDto saveTeam(TeamDto teamDto){
        Team team=new Team();
        team.setTeamId(teamDto.getTeamId());
        team.setTeamName(teamDto.getTeamName());
        team.setTeamPassword(teamDto.getTeamPassword());
        team.setTeamLeader(teamDto.getTeamLeader());
        //team.setTeamCloud(auto);
        team.setBelongedTeam(userDto.getUserId());
        /*
        Team savedTeam=teamRepository.save(team);
        TeamResponseDto teamResponseDto=new TeamResponseDto();
        teamResponseDto.setTeamId(savedTeam.getTeamId());
        teamResponseDto.setTeamName(savedTeam.getTeam)
         */

        return;
    }

    @Override
    public TeamResponseDto getTeam(TeamDto teamDto){

    }

    @Override TeamResponseDto updateTeam(TeamDto teamDto){

    }

    @Override
    public void deleteTeam(String teamId){
        teamRepository.deleteById(teamId);-
    }

}
