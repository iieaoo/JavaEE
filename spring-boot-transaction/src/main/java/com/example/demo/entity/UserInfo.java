package com.example.demo.entity;

import lombok.Data;

/**
 * ClassName: UserInfo
 * Package: com.example.demo.entity
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/29 20:19
 * Version 1.0
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private Integer state;
}
