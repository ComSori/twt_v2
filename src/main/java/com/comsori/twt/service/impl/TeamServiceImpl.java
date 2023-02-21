package com.comsori.twt.service;

import com.comsori.twt.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository=teamRepository;
    }
    @Override
    public void TeamCreateDto(TeamRepository teamRepository){
        TeamCreateDto teamCreateDto=new TeamCreateDto();
        teamCreateDto.
    }

}
