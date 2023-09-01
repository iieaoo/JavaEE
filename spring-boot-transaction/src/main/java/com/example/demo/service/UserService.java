package com.example.demo.service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: UserService
 * Package: com.example.demo.service
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/29 20:31
 * Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    public Integer add(UserInfo userInfo) {
        int result = userMapper.add(userInfo);
        System.out.println("用户添加：" + result);
        return result;
    }

}
