package com.example.demo.config;

import java.lang.annotation.*;

/**
 * 返回结果处理标记注解
 *
 * @author ：Mr.Garlic
 * @date ： 2021/1/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}

