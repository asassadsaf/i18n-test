package com.fkp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fkp.param.RestResponse;
import com.fkp.util.I18nUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<User> user(@RequestParam("name") String name){
//        int i = 1/0;
        User user = new User();
        user.setName(name);
        return new RestResponse<User>("000000","success","000000", user);
    }

    //接收post请求ContentType=text/plain类型参数
    //请求为post请求时请求头中才有contentType,代表请求体的数据类型，get请求没有ContentType,请求头中的Accept为请求可以接收的数据类型
    //produces指定响应的数据类型即响应头中的ContentType属性，consumes指定该RequestMapping能接收的请求数据类型，对应请求头中的ContentType属性，若为get请求则不能指定，因为此时请求头中没有ContentType属性
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public String error(@RequestBody String params){
        JSONObject jsonObject = JSON.parseObject(params);
        String name = jsonObject.getString("name");
        System.out.println(name);
        String message = messageSource.getMessage("W0001", new Object[]{}, LocaleContextHolder.getLocale());
        System.out.println(message);
        return message;
    }

    static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
