package com.alex.bunny.enums;

public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    PRIMAYY_SCHOOL(100, "你可能还在上小学啦"),
    MIDDLE_SCHOOL(101, "你可能还在上初中啦"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
