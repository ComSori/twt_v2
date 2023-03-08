package com.comsori.twt.service.impl;

import com.comsori.twt.data.dto.TeamBuildDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.dto.TeamUpdateDto;
import com.comsori.twt.data.entity.BelongedTeam;
import com.comsori.twt.data.entity.Team;
import com.comsori.twt.repository.TeamRepository;
import com.comsori.twt.repository.UserRepository;
import com.comsori.twt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService  {
    //todo [jhs] : 팀원 초대 강퇴기능 구현
    private TeamRepository teamRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, UserRepository userRepository){
        this.teamRepository=teamRepository;
        this.userRepository=userRepository;//jwt token으로 대체
    }

    @Override
    public void buildTeam(TeamBuildDto teamBuildDto){
        //todo [jhs] : 토큰인증후 팀생성으로 builder 코드 변경 +id isEmpty 검증, 실패 처리 (현재 미완)
        Team team=new Team();
        team.setTeamId(teamBuildDto.getTeamId());
        team.setTeamName(teamBuildDto.getTeamName());
        team.setTeamPassword(bCryptPasswordEncoder.encode(teamBuildDto.getTeamPassword()));
        team.setTeamLeader(teamBuildDto.getTeamLeader());
        //team.setTeamCloud(auto);
        //team.setBelongedTeam(/*jwt*/);
        teamRepository.save(team);
    }

    @Override
    public void joinTeam(TeamMemberDto teamMemberDto) throws RuntimeException{
        //todo [jhs] : 비밀번호 인증후 팀원 추가 인증
        Team foundTeam=teamRepository.findById(teamMemberDto.getTeamId()).get();
        if(!bCryptPasswordEncoder.matches(teamMemberDto.getTeamPassword(), foundTeam.getTeamPassword()))
            throw new RuntimeException();
        BelongedTeam belongedTeam;
        belongedTeam=BelongedTeam.builder()
                .user(userRepository.findById(teamMemberDto.getUserId()).get())
                .team(teamRepository.findById(teamMemberDto.getTeamId()).get())
                .build();
        //foundTeam.setBelongedTeam(belongedTeamRepository);
        teamRepository.save(foundTeam);
    }

    @Override
    public TeamResponseDto getTeam(String teamId, String userId){
        //todo [jhs] : 팀정보 조회기능 구현, 조회하려는 팀내 userId가 있는지 검증 +belonged team repository 회의
        Team foundTeam=teamRepository.findById(teamId);
        if(!bCryptPasswordEncoder.matches(teamId)){

        }
        return null;
    }

    @Override
    public TeamResponseDto updateTeam(TeamUpdateDto teamUpdateDto){
        //팀 설정(이름, pw만 변경가능)
        Team foundTeam=teamRepository.findById(teamUpdateDto.getTeamId()).get();
        foundTeam.setTeamName(teamUpdateDto.getTeamName());
        foundTeam.setTeamPassword(teamUpdateDto.getTeamPassword());

        Team changedTeam=teamRepository.save(foundTeam);

        return null;
    }

    @Override
    public void deleteTeam(String teamId){
        teamRepository.deleteById(teamId);
    }
}
