package com.demo.component;

import org.springframework.stereotype.Controller;

/**
 * ClassName: aController
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/16 12:46
 * Version 1.0
 */
@Controller
public class aController {
    public String sayHi() {
        return "Hi,Controller.";
    }
}
