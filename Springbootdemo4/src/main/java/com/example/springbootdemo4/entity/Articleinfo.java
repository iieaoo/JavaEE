package com.example.springbootdemo4.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: Articleinfo
 * Package: com.example.springbootdemo4.entity.vo
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/27 14:36
 * Version 1.0
 */
@Data
public class Articleinfo implements Serializable {
    private final long serializableId = 1L;
    private int id;
    private String title;
    private String contentl;
    private String createtime;
    private String updatetime;
    private int uid;
    private int rcount;
    private int state;
}
