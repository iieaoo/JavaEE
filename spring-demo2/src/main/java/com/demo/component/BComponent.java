package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ClassName: BComponent
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 22:54
 * Version 1.0
 */
@Component
public class BComponent {

    @Autowired
    private CComponent component;

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行力 B 对象的 PostConstruct 方法");
    }
}
