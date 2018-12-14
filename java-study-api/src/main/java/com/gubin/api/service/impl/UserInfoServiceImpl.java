package com.gubin.api.service.impl;

import com.gubin.api.domain.UserInfo;
import com.gubin.api.repository.UserInfoRepository;
import com.gubin.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public List<UserInfo> getUserInfoByList(){
        return userInfoRepository.getUserInfoByList() ;
    }

    public void saveUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo) ;
    }

    public void updateUserInfo(UserInfo userInfo){
    }
}