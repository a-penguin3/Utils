package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum ResultCode {


    SUCCESS(200,"success"),
    ERROR(500,"执行失败");

    private final Integer code;
    private final String msg;

    ResultCode(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
