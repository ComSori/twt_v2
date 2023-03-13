package com.comsori.twt.service.impl;

import com.comsori.twt.data.dto.TeamBuildDto;
import com.comsori.twt.data.dto.TeamMemberDto;
import com.comsori.twt.data.dto.TeamResponseDto;
import com.comsori.twt.data.dto.TeamDto;
import com.comsori.twt.data.entity.BelongedTeam;
import com.comsori.twt.data.entity.Team;
import com.comsori.twt.data.entity.User;
import com.comsori.twt.repository.BelongedTeamRepository;
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
    private BelongedTeamRepository belongedTeamRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public TeamServiceImpl(
            TeamRepository teamRepository,
            UserRepository userRepository,
            BelongedTeamRepository belongedTeamRepository){
        this.teamRepository=teamRepository;
        this.userRepository=userRepository;//jwt token으로 대체
        this.belongedTeamRepository=belongedTeamRepository;
    }

    @Override
    public void buildTeam(TeamBuildDto teamBuildDto){
        //todo [jhs] : 토큰인증후 팀생성으로 builder 코드 변경 +id isEmpty 검증, 실패 처리 (현재 미완)
        //Team builder()
        Team team;
        team=Team.builder()
                        .teamId(teamBuildDto.getTeamId())
                        .teamPassword(bCryptPasswordEncoder.encode(teamBuildDto.getTeamPassword()))
                        .teamName(teamBuildDto.getTeamName())
                        .teamLeader(teamBuildDto.getTeamLeader())
                        .build();
        //team.setTeamCloud(auto);
        //BelongedTeam builder
        User foundUser=userRepository.findByUserId(teamBuildDto.getTeamLeader()).get();
        BelongedTeam buildBelongedTeam;
        buildBelongedTeam=BelongedTeam.builder()
                        .user(foundUser)
                        .team(team)
                        .build();
        //Repository Save
        belongedTeamRepository.save(buildBelongedTeam);
        teamRepository.save(team);
    }

    @Override
    public void joinTeam(TeamMemberDto teamMemberDto) throws RuntimeException{
        Team foundTeam=teamRepository.findById(teamMemberDto.getTeamId()).get();
        if(!bCryptPasswordEncoder.matches(teamMemberDto.getTeamPassword(), foundTeam.getTeamPassword()))
            throw new RuntimeException();
        BelongedTeam belongedTeam;
        belongedTeam=BelongedTeam.builder()
                .user(userRepository.findById(teamMemberDto.getUserId()).get())
                .team(teamRepository.findById(teamMemberDto.getTeamId()).get())
                .build();
        //foundTeam.setBelongedTeam(belongedTeamRepository);
        belongedTeamRepository.save(belongedTeam);
    }

    @Override
    public TeamResponseDto getTeam(String teamId, String userId){
        //todo [jhs] : 팀정보 조회기능 구현, 조회하려는 팀내 userId가 있는지 검증 +belonged team repository 회의
        Team foundTeam=teamRepository.findById(teamId).get();
        if(!bCryptPasswordEncoder.matches(foundTeam.getBelongedTeam().)){

        }
        return null;
    }

    @Override
    public TeamResponseDto updateTeam(TeamDto teamDto){
        //팀 설정(이름, pw만 변경가능)
        Team foundTeam=teamRepository.findById(teamDto.getTeamId()).get();
        foundTeam.setTeamName(teamDto.getTeamName());
        foundTeam.setTeamPassword(teamDto.getTeamPassword());

        Team changedTeam=teamRepository.save(foundTeam);

        return null;
    }

    @Override
    public void deleteTeam(TeamMemberDto teamMemberDto){

        teamRepository.deleteById(teamId);
    }
}
