package com.example.demo.controller;

import com.example.demo.config.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@ResponseResult
public class TestController {

    @GetMapping("/success")
    public Object getSuccess(){
        return "success";
    }

}
