package com.example.springbootdemo4.entity.vo;

import com.example.springbootdemo4.entity.Articleinfo;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: ArticleinfoVO
 * Package: com.example.springbootdemo4.entity.vo
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/27 14:39
 * Version 1.0
 */
@Data
public class ArticleinfoVO extends Articleinfo implements Serializable {  //Serializable进行持久化的接口，防止进行序列化的时候报错
    private final long serializableId = 1L;
    private String username;

    @Override
    public String toString() {
        return "ArticleinfoVO{" +
                "username='" + username + '\'' +
                "} " + super.toString();
    }
}
