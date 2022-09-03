package com.fkp.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        //当RequestMapping方法返回类型为String或Void且没有返回视图时，若发生异常且没有响应数据,会再次请求/error资源，若使用全局异常处理器捕获后响应了数据则不会再次请求/error资源
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/error");
    }
}
