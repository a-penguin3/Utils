package com.example.demo.config;

import com.example.demo.enums.ResultCode;
import com.example.demo.enums.StatusCode;
import lombok.Getter;

@Getter
public class APIException extends RuntimeException {


    private final int code;
    private final String msg;

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = ResultCode.ERROR.getCode();
        this.msg = ResultCode.ERROR.getMsg();
    }

}
