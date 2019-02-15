package com.gubin.common.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
@XStreamAlias("head")
public class Head {
    private String id;
    private String code;
    private String msg;
}
