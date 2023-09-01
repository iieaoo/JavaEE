package com.example.springbootaopdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ArticleControlller
 * Package: com.example.springbootaopdemo.controller
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/28 16:04
 * Version 1.0
 */
@RestController
@RequestMapping("/art")
public class ArticleControlller {

    @RequestMapping("/hi")
    public String sayHi() {
        System.out.println("执行了 Hi 方法！");
        return "Hi, word.";
    }

}
