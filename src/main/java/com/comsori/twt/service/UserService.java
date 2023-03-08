package com.comsori.twt.service;

import com.comsori.twt.data.dto.*;

public interface UserService {
    public void insertUser(UserJoinDto userJoinDto);
    public void updateUser(UserUpdateDto userUpdateDto);
    public void deleteUser(String userId);

    public boolean validationCheckUser(String userId);
}
