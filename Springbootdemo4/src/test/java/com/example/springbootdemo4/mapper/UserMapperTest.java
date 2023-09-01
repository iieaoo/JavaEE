package com.example.springbootdemo4.mapper;

import com.example.springbootdemo4.entity.Userinfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: UserMapperTest
 * Package: com.example.springbootdemo4.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/26 17:02
 * Version 1.0
 */
@SpringBootTest //1、表明当前单元测试是运行在 Spring Boot 环境中的
//@Transactional //不污染数据库
class UserMapperTest {

    // 2、注入测试对象
    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserById() {
        // 3、单元测试的业务代码
        Userinfo userinfo = userMapper.getUserById(1);
        System.out.println(userinfo);
//        Assertions.assertEquals("zhangsan",userinfo.getUsername());
    }

    @Test
    void getAll() {
        List<Userinfo> list = userMapper.getAll();
        System.out.println(list);
    }

    @Test
    void add() {
        // 伪代码，构建对象并设置相应的值
        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("张三");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        // 调用 mybatis 添加方法执行添加操作
        int result = userMapper.add(userinfo);
        System.out.println("添加: " + result);

        int uid = userinfo.getId();
        System.out.println("用户Id:" + uid);

        Assertions.assertEquals(1,result);
    }

    @Test
    void addGetId() {
        // 伪代码，构建对象并设置相应的值
        Userinfo userinfo = new Userinfo();
//        userinfo.setUsername("xiaoliu");
        userinfo.setPassword("123");
        userinfo.setCreatetime(LocalDateTime.now());
        userinfo.setUpdatetime(LocalDateTime.now());
        // 调用 mybatis 添加方法执行添加操作
        int result = userMapper.addGetId(userinfo);
        System.out.println("添加: " + result);

        int uid = userinfo.getId();
        System.out.println("用户Id:" + uid);

        Assertions.assertEquals(1,result);
    }


    @Test
    void upUserName() {
        //构造测试数据
        Userinfo userinfo = new Userinfo();
        userinfo.setId(5);
//        userinfo.setUsername("小六");
        int result = userMapper.upUserName(userinfo);
        System.out.println("修改：" + result);
        Assertions.assertEquals(1,result);
    }

    @Test
    void delById() {
        Integer id = 1;
        int result = userMapper.delById(id);
        System.out.println("删除：" + result);
        Assertions.assertEquals(1,result);
    }

    @Test
    void getUserByName() {
        List<Userinfo> list = userMapper.getUserByName("zhangsan");
        System.out.println("查询：" + list.size());
    }

    @Test
    void getListByOrder() {
        List<Userinfo> list = userMapper.getListByOrder("desc");    //倒序，正序 asc
        System.out.println(list);
    }

    @Test
    void login() {
        String username = "admin";
        String password = "admin";
        Userinfo userinfo = userMapper.login(username,password);
        System.out.println("登录状态: " + (userinfo == null ? "失败" : "成功"));
    }

    @Test
    void getListByName() {
        String username = "m";
        List<Userinfo> list = userMapper.getListByName(username);
        System.out.println("list:" + list);
    }

    @Test
    void add2() {

        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("小明");
        userinfo.setPhoto(null);
        userinfo.setPassword("1234");
        int result = userMapper.add2(userinfo);
        System.out.println("添加：" + result);

    }

    @Test
    void add3() {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("珍妮");
        userinfo.setPassword("123");
        userinfo.setPhoto("default.png");
        int result = userMapper.add3(userinfo);
        System.out.println("添加：" + result);
    }

    @Test
    void getListByParam() {
        List<Userinfo> list = userMapper.getListByParam(null,null);
        System.out.println(list);
    }

    @Test
    void update2() {
        Userinfo user = new Userinfo();
        user.setId(5);
        user.setUsername(null);
        user.setPassword(null);
        user.setPhoto("default.png");
        int result = userMapper.update2(user);
        System.out.println("修改：" + result);
    }

    @Test
    void delts() {
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(12);
        int result = userMapper.delts(ids);
        System.out.println("删除：" + result);
    }
}