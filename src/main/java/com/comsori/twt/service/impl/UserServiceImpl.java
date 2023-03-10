package com.comsori.twt.service.impl;

<<<<<<<< HEAD:src/main/java/com/comsori/twt/service/impl/UserServiceImpl.java
import com.comsori.twt.data.dto.UserJoinDto;
import com.comsori.twt.data.dto.UserUpdateDto;
import com.comsori.twt.data.entity.User;
import com.comsori.twt.repository.UserRepository;
import com.comsori.twt.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    public void insertUser(UserJoinDto userJoinDto) {
        String encPwd = bCryptPasswordEncoder.encode(userJoinDto.getUserPassword());
        userJoinDto.setUserPassword(encPwd);
        userRepository.save(userJoinDto.toEntity());
    }

    @Transactional
    // 회원 수정시 세션도 바꾸는 코드 추가하기
    public void updateUser(UserUpdateDto userUpdateDto) {
        System.out.println(userUpdateDto.getUserId());
        User selectedUser = userRepository.findByUserId(userUpdateDto.getUserId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("존재하지 않는 회원입니다.");
                });

        String encPwd = bCryptPasswordEncoder.encode(userUpdateDto.getUserPassword());
        selectedUser.setUserPassword(encPwd);
        selectedUser.setUserName(userUpdateDto.getUserName());
        selectedUser.setUserEmail(userUpdateDto.getUserEmail());
        selectedUser.setUserPhone(userUpdateDto.getUserPhone());
        selectedUser.setUserUniversity(userUpdateDto.getUserUniversity());
        selectedUser.setUserDefaultTeam(userUpdateDto.getUserDefaultTeam());

    }

    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public boolean validationCheckUser(String userId) {
        return userRepository.existsByUserId(userId);
    }
========
import com.comsori.twt.data.dto.*;

public interface UserService {
    public void insertUser(UserJoinDto userJoinDto);
    public void updateUser(UserUpdateDto userUpdateDto);
    public void deleteUser(String userId);

    public boolean validationCheckUser(String userId);
>>>>>>>> 3b17d6ac99472f36e7d9ee46c82d3cdd31f75dfa:src/main/java/com/comsori/twt/service/UserService.java
}
