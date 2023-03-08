package com.comsori.twt.config.auth;

import com.comsori.twt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public PrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PrincipalDetails principal = new PrincipalDetails(userRepository.findByUserId(username).orElseThrow(
                () -> new UsernameNotFoundException("존재하지 않는 회원입니다.")
        ));
        return principal;
    }
}
