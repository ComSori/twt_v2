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
    @JoinColumn(nullable = false)
    private Lecture lecture;

    @Id
    @Enumerated(EnumType.STRING)
    private WeekType lec_week;

    @Id
    private LocalTime lec_start;

    @Column(nullable = false)
    private LocalTime lec_end;
}
