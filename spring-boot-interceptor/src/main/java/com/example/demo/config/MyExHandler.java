package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * ClassName: MyExHandler
 * Package: com.example.demo.config
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/29 2:03
 * Version 1.0
 */
@ControllerAdvice
public class MyExHandler {

    // 拦截所有的空指针异常，进行统一的数据返回
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public HashMap<String,Object> nullException(NullPointerException e) {
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","空指针异常：" + e.getMessage());   //错误码的描述信息
        result.put("data",null);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HashMap<String,Object> exception(Exception e) {
        HashMap<String,Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg","空指针异常：" + e.getMessage());   //错误码的描述信息
        result.put("data",null);
        return result;
    }

}
