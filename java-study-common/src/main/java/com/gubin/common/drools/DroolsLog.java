package com.gubin.common.drools;

import lombok.Data;

@Data
public class DroolsLog {

    private String code;

    private String message;

    private Boolean success;

    public DroolsLog(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
