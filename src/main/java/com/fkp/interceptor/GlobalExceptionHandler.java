package com.fkp.interceptor;

import com.alibaba.fastjson.JSON;
import com.fkp.param.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public void exceptionHandler(Exception e, HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("经过全局异常处理器的exceptionHandler方法");
        log.info("请求路径：{}",request.getRequestURI());
        String message = e.getMessage();
        Map<String, String> res = new HashMap<>();
        res.put("code", "999999");
        res.put("status", "fail");
        res.put("msg", message == null ? "" : message);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JSON.toJSONString(res));
    }
}
