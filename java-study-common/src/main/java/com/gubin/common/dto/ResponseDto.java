package com.gubin.common.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private Boolean success;

    private String code;

    private String message;

    private Object data;

    /**
     * 成功
     */
    public static ResponseDto SUCCESS() {
        return new ResponseDto(true, ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }

    /**
     * 成功加消息
     */
    public static ResponseDto SUSSCCEMSG(String message) {
        return new ResponseDto(true, ResponseEnum.SUCCESS.getCode(), message);
    }

    /**
     * 成功加数据
     */
    public static ResponseDto SUCCESSDATA(Object data) {
        return new ResponseDto(true, ResponseEnum.SUCCESS.getCode(), data, ResponseEnum.SUCCESS.getMessage());
    }

    /**
     * 请求失败
     */
    public static ResponseDto ERROR() {
        return new ResponseDto(false, ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMessage());
    }

    /**
     * 请求失败
     */
    public static ResponseDto ERRORMSG(String message) {
        return new ResponseDto(false, ResponseEnum.ERRORMSG.getCode(), message);
    }

    /**
     * 系统错误
     */
    public static ResponseDto SYSTEMERROR() {
        return new ResponseDto(false, ResponseEnum.SYSTEMERROR.getCode(), ResponseEnum.SYSTEMERROR.getMessage());
    }

    /**
     * 参数错误
     */
    public static ResponseDto PARAMERROR() {
        return new ResponseDto(false, ResponseEnum.PARAMERROR.getCode(), ResponseEnum.PARAMERROR.getMessage());
    }

    ResponseDto(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    ResponseDto(boolean success, String code, Object data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }

}
