package com.comsori.twt.controller.api;

import com.comsori.twt.data.dto.UserJoinDto;
import com.comsori.twt.data.entity.User;
import com.comsori.twt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 아이디, 비밀번호, 이메일 등 유효성 검증 기능 추가하기
@RestController
public class UserApiController {

    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    // 같은 아이디 있으면 돌려보내기.
    @PostMapping("/user/signUp")
    public ResponseEntity<String> userAdd(@RequestBody UserJoinDto userJoinDto) {
        userService.insertUser(userJoinDto);
        return new ResponseEntity<String>("회원가입 완료", HttpStatus.OK);
    }

    @PutMapping("/user/update")
    public ResponseEntity<String> userModify(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<String>("회원수정 완료", HttpStatus.OK);
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<String> userRemove(String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("회원탈퇴 완료", HttpStatus.OK);
    }

    @PostMapping("/user/check")
    public ResponseEntity<Boolean> userCheck(String userId) {
        boolean exist = userService.validationCheckUser(userId);

        return new ResponseEntity<Boolean>(exist, HttpStatus.OK);
    }
}
