package com.comsori.twt.controller.api;

import com.comsori.twt.config.SecurityConfig;
import com.comsori.twt.data.dto.TeamBuildDto;
import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/{team}")
    public ResponseEntity<TeamResponseDto> teamGet(
            @PathVariable(value="team") String teamId,
            @RequestHeader(value="Authorization")String payload){
        //todo [jhs] : 검증 추가, team service에 검증 메서드 추가, 검증후 오류 및 실패처리
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        return teamService.getTeam(teamId,auth.getPrincipal().toString());
    }
    @GetMapping("/check")
    public ResponseEntity<?> teamCheck(@RequestParam String id){
        //todo [jhs] : 팀 아이디 검사 기능 추가
        return new ResponseEntity<>("성공",HttpStatus.OK)
    }
    @PostMapping("/build")
    public ResponseEntity<String> teamBuild(@RequestBody TeamBuildDto teamBuildDto){
        teamService.buildTeam(teamBuildDto);
        //Todo [jhs] : authentication 현재 선택된 팀 추가 - Build
        return new ResponseEntity<String>("팀생성 성공", HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<String> teamJoin(@RequestBody TeamMemberDto teamMemberDto){
        teamService.joinTeam(teamMemberDto);
        //Todo [jhs] : authentication 현재 선택된 팀 추가 - Join
        return new ResponseEntity<>("팀 가입 성공",HttpStatus.OK);
    }
    @PutMapping("/setting/{team}")
    public TeamResponseDto teamSetting(@RequestBody TeamDto teamDto){
        TeamResponseDto teamResponseDto=teamService.updateTeam(teamDto);
        return teamResponseDto;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> teamDelete(@RequestBody TeamMemberDto teamMemberDto){
        teamService.deleteTeam(teamMemberDto);
        return new ResponseEntity<String>("팀 삭제 성공", HttpStatus.OK);
    }

}