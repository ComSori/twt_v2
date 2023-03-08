package com.comsori.twt.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String userEmail;

    @Column
    private String userPhone;

    @Column
    private String userUniversity;

    @Column
    private String userRole;

    @Column
    private String userDefaultTeam;

    @OneToMany(mappedBy = "user")
    private List<Schedule> schedule;

    @OneToMany(mappedBy = "user")
    private List<UserLec> userLec;

    @OneToMany(mappedBy = "user")
    private List<BelongedTeam> belongedTeam;
}
