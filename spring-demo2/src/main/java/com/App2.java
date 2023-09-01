package com;

import com.demo.component.BeanLifeComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: App2
 * Package: com
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/19 22:36
 * Version 1.0
 */
public class App2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext
                 = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanLifeComponent beanLifeComponent = applicationContext.getBean("myComponent",
                BeanLifeComponent.class);
        System.out.println("使用Bean");
        //销毁 Bean
        applicationContext.destroy();
    }
}
