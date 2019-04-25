//package com.oe.account.config;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author wangwj
// * @data 2019/4/16
// */
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public Map<String, Object> handler() {
//
//        Map<String, Object> result = new HashMap<>(2);
//        result.put("code", -1);
//        result.put("msg", "系统出错啦");
//        return result;
//    }
//}
