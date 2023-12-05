package com.example.demo.interceptor;


import com.example.demo.config.ResponseResult;
import jakarta.annotation.Nonnull;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

/**
 * ResponseResult注解拦截器
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    /**
     * 标记名称
     */
    public static final String RESPONSE_NEED_RESULT = "RESPONSE_NEED_RESULT";


    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request,@Nonnull HttpServletResponse response,@Nonnull Object handler) throws Exception {
        //请求方法
        if(handler instanceof HandlerMethod handlerMethod){
            //  拿到的是方法所在的controller类的class类
            final Class<?> clazz = handlerMethod.getBeanType();
            // 拿到method对象
            final Method method = handlerMethod.getMethod();
            // 判断是否在类对象上面加了注解
            if(clazz.isAnnotationPresent(ResponseResult.class)){
                // 设置此请求返回体
                request.setAttribute(RESPONSE_NEED_RESULT,
                        clazz.getAnnotation(ResponseResult.class));
            }else if(method.isAnnotationPresent(ResponseResult.class)){
                // 设置此请求返回体
                request.setAttribute(RESPONSE_NEED_RESULT,
                        method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
