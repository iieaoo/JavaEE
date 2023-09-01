package com.example.springbootdemo4.service;

import com.example.springbootdemo4.entity.Userinfo;
import com.example.springbootdemo4.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Package: com.example.springbootdemo4.service
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/26 15:57
 * Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Userinfo getUserById(int id) {
        return userMapper.getUserById(id);
    }

}
