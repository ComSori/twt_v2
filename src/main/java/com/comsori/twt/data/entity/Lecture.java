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
    @Column(name = "lec_code")
    private String lecCode;

    @Column(nullable = false)
    private String lecName;

    @Column(nullable = false)
    private String lecProfessor;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<LecTime> lecTime;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<UserLec> lecUser;
}
