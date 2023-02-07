package com.comsori.twt.data.embeddedid;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BelongedTeamId implements Serializable {

    private String user;

    private String team;
}
