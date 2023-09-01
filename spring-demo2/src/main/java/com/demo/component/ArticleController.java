package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * ClassName: ArticleController
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/16 11:29
 * Version 1.0
 */
@Controller
public class ArticleController {
    public String sayHello() {
        return "Hello, Controller.";
    }
}
