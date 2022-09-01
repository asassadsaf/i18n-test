package com.fkp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(@RequestParam("name") String name){
        int i = 1/0;
        User user = new User();
        user.setName(name);
        return user ;
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
