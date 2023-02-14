package com.comsori.twt.data.dto;

import com.comsori.twt.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinDto {
    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private String userUniversity;

    public User toEntity() {
        return User.builder()
                .userId(this.getUserId())
                .userName(this.getUserName())
                .userPassword(this.getUserPassword())
                .userEmail(this.getUserEmail())
                .userPhone(this.getUserPhone())
                .userUniversity(this.getUserUniversity())
                .build();
    }
}
