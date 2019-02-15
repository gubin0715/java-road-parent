package com.gubin.common.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("head")
public class Head {
    private String id;
    private String code;
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
