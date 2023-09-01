package com;

import com.demo.component.AComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: App3
 * Package: com
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 23:00
 * Version 1.0
 */
public class App3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AComponent aComponent = context.getBean("AComponent", AComponent.class);
    }
}
