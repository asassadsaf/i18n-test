package com.fkp.controller;

import com.fkp.param.RestResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(value = "/i18n")
public class I18nController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<User> test(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);
        return RestResponse.success(user);
    }

    @RequestMapping(value = "valid", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RestResponse<User> valid(@Valid User user){
        return RestResponse.success(user);
    }

    static class User{
        @NotBlank(message = "{user.name.notBlank}")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
