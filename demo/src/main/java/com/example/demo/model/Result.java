package com.example.demo.model;

import com.example.demo.enums.ResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "返回响应体")
public class Result<T>{

    @Schema(
            title = "code",  //用于显示在生成的文档中的标题。
            name = "看看怎么显示",    //指定属性名。该属性只对属性有效，对类无效。
            description = "请求状态码",  //用于描述该类或属性的作用
            format = "int32",
            example = "200",
            //默认AUTO：可有可无；REQUIRED：必须存在此字段(会加红色*)；NOT_REQUIRED：不需要存在此字段
            requiredMode = Schema.RequiredMode.NOT_REQUIRED //用于指定该属性是否必填项。
    )
    private Integer code;
    @Schema(
            title = "msg",
            name = "执行结果",
            description = "请求结果",
            example = "success"
    )
    private String msg;
    @Schema(
            title = "data",
            description = "返回数据体"
    )
    private T data;

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static <T> Result<T> success(){
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(ResultCode.SUCCESS,data);
    }

    public static <T> Result<T> failure(){
        return new Result<>(ResultCode.ERROR);
    }

    public static <T> Result<T> failure(T data){
        return new Result<>(ResultCode.ERROR,data);
    }

}
