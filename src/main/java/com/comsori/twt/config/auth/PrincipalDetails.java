package com.comsori.twt.config.auth;

import com.comsori.twt.data.entity.User;
import com.comsori.twt.data.type.RoleType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// to Do : User 관련 컨트롤러, 서비스에서 user_Role 넣어주기.
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(() -> {
            return user.getUserRole().toString();
        });

        return collection;
    }

    public String getUserId() {
        return user.getUserId();
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    public String getUserEmail() {
        return user.getUserEmail();
    }

    public String getUserPhone() {
        return user.getUserPhone();
    }

    public String getUserUniversity() {
        return user.getUserUniversity();
    }

    public String getUserDefaultTeam() {
        return user.getUserDefaultTeam();
    }

    public RoleType getUserRole() {
        return user.getUserRole();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
