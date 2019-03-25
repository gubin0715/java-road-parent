package com.gubin.repository;

import com.gubin.common.entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userInfoRepository")
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer>{

    @Query("select l from UserInfo l where 1=1 ")
    public List<UserInfo> getUserInfoByList();

}