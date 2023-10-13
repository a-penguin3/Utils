package com.example.demo.model;

import com.example.demo.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, Object data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS,data);
    }

    public static Result failure(){
        return new Result(ResultCode.ERROR);
    }

    public static Result failure(Object data){
        return new Result(ResultCode.ERROR,data);
    }

}
