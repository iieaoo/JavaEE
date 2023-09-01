package com.demo.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ClassName: CComponent
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 22:55
 * Version 1.0
 */
@Component
public class CComponent {
    @PostConstruct
    public void postConstruct() {
        System.out.println("执行力 C 对象的 PostConstruct 方法");
    }

}
