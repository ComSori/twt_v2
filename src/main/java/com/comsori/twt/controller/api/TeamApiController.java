package com.comsori.twt.controller.api;

import com.comsori.twt.data.dto.TeamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamApiController {

    @PostMapping("/build")
    public ResponseEntity<String> teamBuild(@RequestBody TeamDto teamDto){
        teamService.
    }

    @PostMapping("/join")

    @PostMapping("/{team}")

    @PutMapping("/update")

    @DeleteMapping("/delete")

}