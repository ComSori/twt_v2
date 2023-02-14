package com.comsori.twt.service;

import com.comsori.twt.data.dto.UserJoinDto;
import com.comsori.twt.data.entity.User;
import com.comsori.twt.repository.UserRepository;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
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
    public void updateUser(User user) {
        User selectedUser = userRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> {
                    return new IllegalArgumentException("존재하지 않는 회원입니다.");
                });

        String encPwd = bCryptPasswordEncoder.encode(user.getUserPassword());
        selectedUser.setUserPassword(encPwd);
        selectedUser.setUserName(user.getUserName());
        selectedUser.setUserEmail(user.getUserEmail());
        selectedUser.setUserPhone(user.getUserPhone());
        selectedUser.setUserUniversity(user.getUserUniversity());
        selectedUser.setUserDefaultTeam(user.getUserDefaultTeam());

    }

    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Transactional
    public boolean validationCheckUser(String userId) {
        return userRepository.existsByUserId(userId);
    }
}
