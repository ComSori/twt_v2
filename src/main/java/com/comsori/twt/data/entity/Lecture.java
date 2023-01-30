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
public class Lecture {
    @Id
    private String lec_code;

    @Column(nullable = false)
    private String lec_name;

    @Column(nullable = false)
    private String lec_professor;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<LecTime> lecTime;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<UserLec> lec_user;
}
