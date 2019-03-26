package com.gubin.common.dto;

public enum ResponseEnum {
    SUCCESS("200", "请求成功"),
    ERROR("500", "请求失败"),
    PARAMERROR("1001", "参数错误"),
    ERRORMSG("100", "其他错误"),
    SYSTEMERROR("9999", "系统错误");
    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
