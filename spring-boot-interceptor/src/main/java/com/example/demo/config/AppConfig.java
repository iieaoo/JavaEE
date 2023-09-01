package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: AppConfig
 * Package: com.example.demo.config
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/28 21:25
 * Version 1.0
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")    // 拦截所有请求
//                .excludePathPatterns("/user/login") //排除的url地址（不拦截的url地址）
//                .excludePathPatterns("/user/reg")
//                .excludePathPatterns("/**/*.html");
        //registry..... //多个拦截器继续写
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("zhangsan", c -> true);
//    }
}
