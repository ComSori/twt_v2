package com.comsori.twt.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamApiController {

    @PostMapping("/build")
    public ResponseEntity<String> teamBuild(@RequestBody TeamBuildDto teamBuildDto){
        teamService.
    }

    @PostMapping("/join")

    @PostMapping("/{team}")

    @PutMapping("/update")

    @DeleteMapping("/delete")

}
