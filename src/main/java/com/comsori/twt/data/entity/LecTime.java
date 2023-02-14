package com.comsori.twt.data.entity;

import com.comsori.twt.data.embeddedid.LecTimeId;
import com.comsori.twt.data.type.WeekType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LecTimeId.class)
public class LecTime {
    @Id
    @ManyToOne
    @JoinColumn(name = "lec_code")
    private Lecture lecture;

    @Id
    @Enumerated(EnumType.STRING)
    private WeekType lecWeek;

    @Id
    private LocalTime lecStart;

    @Column(nullable = false)
    private LocalTime lecEnd;
}
