package com.oe.account.util;

import com.oe.account.enums.ResponseStatus;
import com.oe.account.vo.OeResponse;

/**
 * @author wangwj
 * @data 2019/3/29
 */
public class OeResponseBuilder {

    public static OeResponse buildSuccess(){
        OeResponse response = new OeResponse();
        response.setCode(ResponseStatus.SUCCSEE.getCode());
        return response;
    }

    public static OeResponse buildFailed(Exception e){
        OeResponse response = new OeResponse();
        response.setCode(ResponseStatus.FAILED.getCode());
        response.setMsg(e.getMessage());
        return response;
    }
}
