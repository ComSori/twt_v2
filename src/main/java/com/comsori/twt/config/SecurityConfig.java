package com.comsori.twt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                // front 패키지 구조 나오면 로그인 페이지로 바꾸기(로그인 페이지로)
                .loginPage("/signin")
                // front 패키지 구조 나오면 로그인 페이지로 바꾸기(로그인 요청 주소로)
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/");

        return http.build();
    }
}
