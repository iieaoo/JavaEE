package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * ClassName: BController
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/16 12:56
 * Version 1.0
 */
@Controller
public class BController {
    public String sayHi() {
        return "Hi, world.";
    }
}
