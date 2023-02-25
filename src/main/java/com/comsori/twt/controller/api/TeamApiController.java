package com.comsori.twt.controller.api;

import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/build")
    public ResponseEntity<String> teamBuild(@RequestBody TeamDto teamDto){
        teamService.
    }

    @PostMapping("/join")
    public ResponseEntity<String> teamJoin(@RequestParam)

    @PostMapping("/{team}")

    @PutMapping("/setting/{team}")

    @DeleteMapping("/delete")

}