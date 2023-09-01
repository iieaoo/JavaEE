package com.example.demo.mapper;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Package: com.example.demo.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/29 20:26
 * Version 1.0
 */
@Mapper
public interface UserMapper {

    int add(UserInfo userInfo);

}
