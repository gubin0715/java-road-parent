package com.gubin.common.xml;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

public class Body {
    @XStreamImplicit(itemFieldName = "userInfos")
    private List<UserInfo> userInfos;

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
