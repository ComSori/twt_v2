package com.comsori.twt.repository;

import com.comsori.twt.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.lang.reflect.Member;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
