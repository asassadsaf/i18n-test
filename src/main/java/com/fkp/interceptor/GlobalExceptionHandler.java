package com.fkp.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = {Exception.class})
//    public String exceptionHandler(Exception e){
//        log.info("经过全局异常处理器的exceptionHandler方法");
//        return "捕获全局异常，异常信息为:" + e.getMessage();
//    }
}
