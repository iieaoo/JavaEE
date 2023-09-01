package com.example.demo.controller;

import com.example.demo.entity.UserInfo;
import com.example.demo.service.LogService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.time.LocalDateTime;

/**
 * ClassName: UserController
 * Package: com.example.demo.controller
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/29 20:18
 * Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DataSourceTransactionManager transactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private LogService logService;

    @RequestMapping("/add")
    public int add(UserInfo userInfo) {
        // 非空校验
        if (userInfo == null || StringUtils.hasLength(userInfo.getUsername())
        || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        //1、开启事务
        TransactionStatus transactionStatus  =
                transactionManager.getTransaction(transactionDefinition);

        // 手动设置创建时间和修改时间的默认值
        userInfo.setCreatetime(LocalDateTime.now().toString());
        userInfo.setUpdatetime(LocalDateTime.now().toString());

        int result = userService.add(userInfo);
        System.out.println("添加：" + result);

//        //2、回滚事务
//        transactionManager.rollback(transactionStatus);

        // 3、提交事务
        transactionManager.commit(transactionStatus);

        return result;
    }

    @Transactional(propagation = Propagation.REQUIRED)  // 声明式事务（自动提交）
    @RequestMapping("/insert")
    public Integer insert(UserInfo userInfo) {
        // 非空校验
        if (userInfo==null || !StringUtils.hasLength(userInfo.getUsername())
                || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        //添加用户
        int result = userService.add(userInfo);
        if (result > 0) {
                logService.add();
        }
        //System.out.println("添加 insert：" + result);
//        try {
//            int num = 10/0;
//        } catch (Exception e) {
//            // 1、将异常继续抛出
//            //throw e;
//            System.out.println(e.getMessage());
//            // 2、手动回滚事务
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
        return result;
    }

}
