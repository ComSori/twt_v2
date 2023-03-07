package com.comsori.twt.controller.api;

import com.comsori.twt.data.dto.TeamBuildDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamApiController {

    //workspace는 workspace api 에서 controll
    private final TeamService teamService;
    @Autowired
    public TeamApiController(TeamService teamService){
        this.teamService=teamService;
    }


    @PutMapping("/setting/{team}")

    @DeleteMapping("/delete")

}