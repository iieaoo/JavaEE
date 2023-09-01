package com.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ClassName: AComponent
 * Package: com.demo.component
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 22:52
 * Version 1.0
 */
@Component
public class AComponent {

    @Autowired
    private BComponent bComponent;

    @PostConstruct
    public void postConstruct() {
        System.out.println("执行力 A 对象的 PostConstruct 方法");
    }

}
