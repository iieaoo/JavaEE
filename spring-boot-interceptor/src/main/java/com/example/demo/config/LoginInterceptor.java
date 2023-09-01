package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.handler.Handler;

/**
 * ClassName: loginInterceptor
 * Package: com.example.demo.config
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/28 18:32
 * Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    //此方法返回一个 boolean，如果为 true 表示验证成功，可以继续执行后续流程
    //如果为 false 表示验证失败，后面的流程不能执行了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 用户登录业务判断
        HttpSession session = request.getSession(false); //session不存在，就创建一个，存在就不创建
        if (session!=null && session.getAttribute("userinfo")!=null) {
            // 说明用户已经登录
            return true;
        }
        // 可以跳转到登录页面 or 返回一个 401/403 没有权限码
        response.sendRedirect("/login.html");   //跳转登录页面
        //response.setStatus(403);
        return false;
    }
}
