package com.oe.student.exception;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public class OeException extends Exception {
    private int code;
    private String msg;

    public OeException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
