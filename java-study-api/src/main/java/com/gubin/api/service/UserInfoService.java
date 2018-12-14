package com.gubin.api.service;

import com.gubin.api.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    public List<UserInfo> getUserInfoByList();

    public void saveUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

}