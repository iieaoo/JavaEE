package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.entity.Userinfo;
import com.example.springbootdemo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UseController
 * Package: com.example.springbootdemo4.controller
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/26 16:07
 * Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getuserbyid")
    public Userinfo getUserById(Integer id) {
        if (id == null) {
            return null;
        }
        return userService.getUserById(id);
    }

}
