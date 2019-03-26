package com.gubin.common.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("userInfos")
public class UserInfos {
    private String name;
    private String phone;
}
