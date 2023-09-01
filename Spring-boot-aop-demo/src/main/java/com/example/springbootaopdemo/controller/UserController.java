package com.example.springbootaopdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: com.example.springbootaopdemo.controller
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/28 15:56
 * Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/hi")
    public String sayHi(String name) {
        System.out.println("执行了 sayHi 方法");
        return "Hi," + name;
    }

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println("执行了 sayHello 方法");
        return "Hello, world";
    }

}
