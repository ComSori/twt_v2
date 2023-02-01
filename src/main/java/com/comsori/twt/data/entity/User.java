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
    @Column(name = "user_id")
    private String user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_password;

    @Column
    private String user_email;

    @Column
    private String user_phone;

    @Column
    private String user_university;

    @OneToMany(mappedBy = "user")
    private List<Schedule> schedule;

    @OneToMany(mappedBy = "user")
    private List<UserLec> user_lec;

    @OneToMany(mappedBy = "user")
    private List<BelongedTeam> belongedTeam;
}
