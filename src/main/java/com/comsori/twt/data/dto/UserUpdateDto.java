package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userUniversity;
    private String userDefaultTeam;

    public User toEntity() {
        return User.builder()
                .userId(this.getUserId())
                .userName(this.getUserName())
                .userPassword(this.getUserPassword())
                .userEmail(this.getUserEmail())
                .userPhone(this.getUserPhone())
                .userUniversity(this.getUserUniversity())
                .userDefaultTeam(this.getUserDefaultTeam())
                .build();
    }
}
