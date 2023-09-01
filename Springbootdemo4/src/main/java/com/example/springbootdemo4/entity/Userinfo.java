package com.example.springbootdemo4.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName: Userinfo
 * Package: com.example.springbootdemo4.entity
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/26 15:35
 * Version 1.0
 */
@Data
public class Userinfo implements Serializable {
    private final long serializableId = 1L;
    private int id;
    private String username;
    private String password;
    private String photo;   // 头像
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
