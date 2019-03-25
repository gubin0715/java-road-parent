package com.gubin.service;

import com.gubin.common.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    public List<UserInfo> getUserInfoByList();

    public void saveUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

}