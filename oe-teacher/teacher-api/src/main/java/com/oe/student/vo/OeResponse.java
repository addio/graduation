package com.oe.student.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public class OeResponse implements Vo{

    private int code;

    private String msg;

    private JSONObject body;

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

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }
}
