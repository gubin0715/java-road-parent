package com.gubin.common.xml;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Data;

import java.util.List;

@Data
public class Body {
    @XStreamImplicit(itemFieldName = "userInfos")
    private List<UserInfos> userInfos;
}
