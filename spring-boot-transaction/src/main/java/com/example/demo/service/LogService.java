package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * ClassName: LogService
 * Package: com.example.demo.service
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/30 19:14
 * Version 1.0
 */
@Service
public class LogService {

    @Transactional(propagation = Propagation.REQUIRED)

    public int add() {
        try {
            int num = 10/0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }

}
