package com.comsori.twt.controller.api;

import com.comsori.twt.data.dto.UserJoinDto;
import com.comsori.twt.data.dto.UserUpdateDto;
import com.comsori.twt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 아이디, 비밀번호, 이메일 등 유효성 검증 기능 추가하기
@RestController
public class UserApiController {

    UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signUp")
    public ResponseEntity userAdd(@RequestBody UserJoinDto userJoinDto) {

        // 중복 확인 안하고 누를 경우
//        if (userService.validationCheckUser(userJoinDto.getUserId())) {
//            return new ResponseEntity<String>("아이디 중복확인을 해주세요!", HttpStatus.BAD_REQUEST);
//        }
        userService.insertUser(userJoinDto);
        return new ResponseEntity<String>("회원가입 완료", HttpStatus.OK);
    }

    @PutMapping("/user/update")
    public ResponseEntity userModify(@RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
        return new ResponseEntity<String>("회원수정 완료", HttpStatus.OK);
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity userRemove(@RequestBody Map<String, String> userId) {
        userService.deleteUser(userId.get("userId"));
        return new ResponseEntity<String>("회원탈퇴 완료", HttpStatus.OK);
    }

    @PostMapping("/user/check")
    public ResponseEntity userCheck(@RequestBody Map<String, String> userId) {
        boolean isExist = userService.validationCheckUser(userId.get("userId"));
        return new ResponseEntity<String>("isExist : " + isExist, HttpStatus.OK);
    }
}
