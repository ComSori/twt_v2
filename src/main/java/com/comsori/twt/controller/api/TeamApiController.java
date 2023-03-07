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

    @PostMapping("/build")
    public ResponseEntity<String> teamBuild(@RequestBody TeamBuildDto teamBuildDto){
        teamService.buildTeam(teamBuildDto);//Todo [jhs]:
        return new ResponseEntity<String>("팀생성 성공", HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> teamJoin(@RequestBody TeamMemberDto teamMemberDto){
        teamService.joinTeam(teamMemberDto);
        return new ResponseEntity<>("팀 가입 성공",HttpStatus.OK);
    }

    @GetMapping("/{team}")
    public ResponseEntity<TeamResponseDto> teamGet(
            @PathVariable(value="team") String team,@RequestHeader(value = "Authorization") String token){

    }

    @PutMapping("/setting/{team}")

    @DeleteMapping("/delete")

}