package com.demo.component;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * ClassName: BeanLifeComponent
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 22:28
 * Version 1.0
 */
//@Component
public class BeanLifeComponent implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println("执行了通知");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行了 @PostConstruct");
    }

    public void init() {
        System.out.println("执行了 init-method 方法");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执行销毁方法");
    }

}
