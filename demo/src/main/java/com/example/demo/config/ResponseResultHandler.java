package com.example.demo.config;

import com.example.demo.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 标记名称
     */
    public static final String RESPONSE_NEED_RESULT = "RESPONSE_NEED_RESULT";

    // 判断是否需要执行beforeBodyWrite
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        ResponseResult responseResultAnn = (ResponseResult)request.getAttribute(RESPONSE_NEED_RESULT);
        return responseResultAnn != null;
    }

    //另一种思路  加了注解的  都不封装返回  这段代码简单得多
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
//        return !(methodParameter.getParameterType().isAssignableFrom(ResultVo.class)
//                || methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
//    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof String){
            return toJson(Result.success(body));
        }

        return Result.success(body);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(Exception exception) {
        StringBuilder errorInfo = new StringBuilder();
        BindingResult bindingResult = null;
        if (exception instanceof MethodArgumentNotValidException validException) {
            bindingResult = validException.getBindingResult();
        }
        if (exception instanceof BindException bindException) {
            bindingResult = bindException.getBindingResult();
        }
        for (int i = 0; i < Objects.requireNonNull(bindingResult).getFieldErrors().size(); i++) {
            if (i > 0) {
                errorInfo.append(",");
            }
            FieldError fieldError = bindingResult.getFieldErrors().get(i);
            errorInfo.append(fieldError.getField()).append(" :").append(fieldError.getDefaultMessage());
        }
        log.error(errorInfo.toString());
        //这里返回自己的Result的结果类。
        return Result.failure(errorInfo.toString());
    }

//    @ExceptionHandler({BindException.class})
//    public Result methodArgumentNotValidExceptionHandler(BindException e) {
//        // 从异常对象中拿到ObjectError对象
//        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
//        //objectError.getDefaultMessage()
//        return Result.failure(objectError.getDefaultMessage());
//    }

    //服务异常处理
//    @ExceptionHandler(APIException.class)
//    public Result APIExceptionHandler(APIException e) {
//        // log.error(e.getMessage(), e); 由于还没集成日志框架，暂且放着，写上TODO
//        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
//    }



    private Object toJson(Result response) {
        try {
            return new ObjectMapper().writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("无法转发json格式", e);
        }
    }
}

