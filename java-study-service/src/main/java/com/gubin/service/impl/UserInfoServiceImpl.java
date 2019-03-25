package com.gubin.service.impl;

import com.gubin.common.entity.UserInfo;
import com.gubin.repository.UserInfoRepository;
import com.gubin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    public List<UserInfo> getUserInfoByList() {
        return userInfoRepository.getUserInfoByList();
    }

    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    public void updateUserInfo(UserInfo userInfo) {
    }
}