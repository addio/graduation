package com.oe.account.enums;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public enum  ResponseStatus {
    SUCCSEE(1),
    FAILED(-1);
    private int code;
    ResponseStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }}
